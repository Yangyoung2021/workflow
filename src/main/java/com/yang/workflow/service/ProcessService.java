package com.yang.workflow.service;


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
}
