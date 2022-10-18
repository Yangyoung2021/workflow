package com.yang.workflow.service.impl;

import com.yang.workflow.entity.ExamRelMember;
import com.yang.workflow.service.ExamRelMemberService;
import com.yang.workflow.service.ProcessService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricDetailQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/17 11:21
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ExamRelMemberService examRelMemberService;

    private static final ConcurrentHashMap<String, Object> VARIABLES = new ConcurrentHashMap<>();

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String startExam(String relId) {
        ExamRelMember examRelMember = examRelMemberService.queryById(relId);
        repositoryService.createDeployment()
                .name(examRelMember.getStaffName() + "绩效考核")
                .addClasspathResource("bpmn/exam.bpmn")
                .addClasspathResource("bpmn/exam.png")
                .deploy();
        VARIABLES.put("examRelMember", examRelMember);
        runtimeService.startProcessInstanceByKey("exam", examRelMember.getRelId(), VARIABLES);
        return "启动成功！";
    }

    @Override
    public String checkerExamComplete(String relId) {
        ExamRelMember examRelMember = examRelMemberService.queryById(relId);
        TaskQuery taskQuery = taskService.createTaskQuery();
        // 完成指定员工的任务
        List<Task> taskList = taskQuery.processDefinitionKey("exam").taskAssignee(examRelMember.getCheckerName()).list();
        taskList.forEach(task -> taskService.complete(task.getId()));
        return "审核成功！";
    }

    /**
     * 员工查看自己的所有任务名称
     *  成功
     * @param staffCode
     * @return
     */
    @Override
    public List<String> viewTodo(String staffCode) {
        ExamRelMember examRelMember = examRelMemberService.queryIdByStaffCode(staffCode);
        List<String> taskName = new ArrayList<>();
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> tasks = taskQuery.processDefinitionKey("exam").taskAssignee(examRelMember.getStaffName()).list();
        tasks.forEach(task -> taskName.add(task.getName()));
        return taskName;
    }

    /**
     * 通过业务主键获取流程具体的任务情况
     *  成功
     * @param relId
     * @return
     */
    @Override
    public List<String> viewCurrentProcess(String relId) {
        List<String> details = new ArrayList<>();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(relId).singleResult();
        List<HistoricTaskInstance> historicTaskInstances = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(processInstance.getId()).orderByHistoricTaskInstanceStartTime().desc().list();
        historicTaskInstances.forEach(historicTaskInstance -> {
            String message = "任务id：" + historicTaskInstance.getId() +
                    " 任务名称：" + historicTaskInstance.getName() +
                    " 任务开始时间：" + historicTaskInstance.getStartTime() +
                    " 任务结束：" + historicTaskInstance.getEndTime();
            details.add(message);
        });
        return details;
    }

    /**
     * 员工完成自己的所有任务
     * 成功
     * @param relId
     * @return
     */
    @Override
    public String staffComplete(String relId) {
        ExamRelMember examRelMember = examRelMemberService.queryById(relId);
        TaskQuery taskQuery = taskService.createTaskQuery();
        // 完成指定员工的任务
        List<Task> taskList = taskQuery.processDefinitionKey("exam").taskAssignee(examRelMember.getStaffName()).list();
        taskList.forEach(task -> taskService.complete(task.getId()));
        return "完成任务！";
    }
}
