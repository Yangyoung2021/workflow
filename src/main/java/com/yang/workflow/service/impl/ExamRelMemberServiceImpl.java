package com.yang.workflow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yang.workflow.entity.ExamRelMember;
import com.yang.workflow.mapper.ExamRelMemberMapper;
import com.yang.workflow.service.ExamRelMemberService;
 /**
 * 考核关系表;(ExamRelMember)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-10-16
 */
@Service
public class ExamRelMemberServiceImpl implements ExamRelMemberService{
    @Autowired
    private ExamRelMemberMapper examRelMemberMapper;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param relId 主键
     * @return 实例对象
     */
    @Override
    public ExamRelMember queryById(String relId){
        return examRelMemberMapper.queryById(relId);
    }
    
    /** 
     * 新增数据
     *
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    @Override
    public ExamRelMember insert(ExamRelMember examRelMember){
        examRelMemberMapper.insert(examRelMember);
        return examRelMember;
    }
    
    /** 
     * 更新数据
     *
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    @Override
    public ExamRelMember update(ExamRelMember examRelMember){
        examRelMemberMapper.update(examRelMember);
        return queryById(examRelMember.getRelId());
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param relId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String relId){
        int total = examRelMemberMapper.deleteById(relId);
        return total > 0;
    }
}