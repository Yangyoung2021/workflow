package com.yang.workflow.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.yang.workflow.entity.ExamRelMember;

 /**
 * 考核关系表;(ExamRelMember)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-10-16
 */
@Mapper
public interface ExamRelMemberMapper{
    /** 
     * 通过ID查询单条数据 
     *
     * @param relId 主键
     * @return 实例对象
     */
    ExamRelMember queryById(String relId);
    /** 
     * 统计总行数
     *
     * @param ExamRelMember 查询条件
     * @return 总行数
     */
    long count(ExamRelMember ExamRelMember);
    /** 
     * 新增数据
     *
     * @param ExamRelMember 实例对象
     * @return 影响行数
     */
    int insert(ExamRelMember ExamRelMember);
    /** 
     * 批量新增数据
     *
     * @param entities List<ExamRelMember> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ExamRelMember> entities);
    /** 
     * 批量新增或按主键更新数据
     *
     * @param entities List<ExamRelMember> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ExamRelMember> entities);
    /** 
     * 更新数据
     *
     * @param ExamRelMember 实例对象
     * @return 影响行数
     */
    int update(ExamRelMember ExamRelMember);
    /** 
     * 通过主键删除数据
     *
     * @param relId 主键
     * @return 影响行数
     */
    int deleteById(String relId);
}