package com.yang.workflow.service;

import com.yang.workflow.entity.ExamRelMember;

 /**
 * 考核关系表;(ExamRelMember)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-10-16
 */
public interface ExamRelMemberService{
    /** 
     * 通过ID查询单条数据 
     *
     * @param relId 主键
     * @return 实例对象
     */
    ExamRelMember queryById(String relId);
    /** 
     * 新增数据
     *
     * @param ExamRelMember 实例对象
     * @return 实例对象
     */
    ExamRelMember insert(ExamRelMember ExamRelMember);
    /** 
     * 更新数据
     *
     * @param ExamRelMember 实例对象
     * @return 实例对象
     */
    ExamRelMember update(ExamRelMember ExamRelMember);
    /** 
     * 通过主键删除数据
     *
     * @param relId 主键
     * @return 是否成功
     */
    boolean deleteById(String relId);
}