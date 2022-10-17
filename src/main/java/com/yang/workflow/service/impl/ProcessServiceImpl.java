package com.yang.workflow.service.impl;

import com.yang.workflow.entity.ExamRelMember;
import com.yang.workflow.service.ExamRelMemberService;
import com.yang.workflow.service.ProcessService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private RepositoryService repositoryService;

    @Autowired
    private ExamRelMemberService examRelMemberService;

    private static final ConcurrentHashMap<String, Object> VARIABLES = new ConcurrentHashMap<>();

    @Override
    public String startExam(String relId) {
        ExamRelMember examRelMember = examRelMemberService.queryById(relId);
        repositoryService.createDeployment().name(examRelMember.getStaffName() + "的绩效考核").deploy();
        VARIABLES.put("examRelMember", examRelMember);
        runtimeService.startProcessInstanceByKey("exam", examRelMember.getRelId(), VARIABLES);
        return "启动成功！";
    }
}
