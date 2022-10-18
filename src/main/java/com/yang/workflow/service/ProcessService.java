package com.yang.workflow.service;


import java.util.List;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/17 11:20
 */
public interface ProcessService {

    /**
     * 开启指定员工编码的考核流程
     *
     * @param relId
     * @return
     */
    String startExam(String relId);

    /**
     * 考核人完成绩效计划
     * @param relId
     * @return
     */
    String checkerExamComplete(String relId);

    /**
     * 被考核人完成绩效计划
     * @param relId
     * @return
     */
    String staffComplete(String relId);

    /**
     * 查看代办
     * @param staffCode
     * @return
     */
    List<String> viewTodo(String staffCode);

    /**
     * 查看某个流程的各个任务过程
     * @param relId
     * @return
     */
    List<String> viewCurrentProcess(String relId);
}
