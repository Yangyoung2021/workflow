package com.yang.workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceBuilder;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DemoTest {

    static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    void processDefinition() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        for (int i = 1; i < 10; i++) {
            ProcessInstanceBuilder processInstanceBuilder = runtimeService.createProcessInstanceBuilder().name("A的流程")
                    .processDefinitionKey("exam").businessKey(i + "");
            processInstanceBuilder.start();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ProcessInstance processInstance = processInstanceQuery.processInstanceBusinessKey("1").singleResult();
        String processInstanceId = processInstance.getId();
        List<Task> taskList = taskQuery.processInstanceId(processInstanceId).orderByTaskCreateTime().list();
        for (Task task : taskList) {
        }
    }


}
