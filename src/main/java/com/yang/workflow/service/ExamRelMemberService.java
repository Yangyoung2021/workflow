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
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    ExamRelMember insert(ExamRelMember examRelMember);
    /** 
     * 更新数据
     *
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    ExamRelMember update(ExamRelMember examRelMember);
    /** 
     * 通过主键删除数据
     *
     * @param relId 主键
     * @return 是否成功
     */
    boolean deleteById(String relId);

     /**
      * 通过员工编码查询单条数据
      *
      * @param staffCode 主键
      * @return 实例对象
      */
     ExamRelMember queryIdByStaffCode(String staffCode);
 }