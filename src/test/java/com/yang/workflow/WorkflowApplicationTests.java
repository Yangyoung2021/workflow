package com.yang.workflow;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class WorkflowApplicationTests {

    static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    void contextLoads() {
        System.out.println(processEngine);
    }

    @Test
    void deploy() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .name("考核计划")
                .addClasspathResource("bpmn/exam.bpmn")
                .addClasspathResource("bpmn/exam.png")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }

    @Test
    void instance() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("exam");
        System.out.println("--------------------");
        System.out.println(instance.getProcessDefinitionId());
        System.out.println(instance.getId());
        System.out.println(instance.getActivityId());

    }

    @Test
    void startProcess() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        System.out.println(runtimeService.startProcessInstanceByKey("exam", "groupId@staffCode"));
    }

    @Test
    void completeTask() {
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> taskList = taskQuery.processDefinitionKey("exam").taskAssignee("staff").list();
        for (Task task : taskList) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            taskService.complete(task.getId());
        }
    }
}
