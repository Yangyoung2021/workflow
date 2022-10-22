package com.yang.workflow.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yang.workflow.entity.ExamRelMember;
import com.yang.workflow.service.ExamRelMemberService;

 /**
 * 考核关系表;(ExamRelMember)表控制层
 * @author : http://www.chiner.pro
 * @date : 2022-10-16
 */
@Api(tags = "考核关系表对象功能接口")
@RestController
@RequestMapping("/ExamRelMember")
public class ExamRelMemberController {
    @Autowired
    private ExamRelMemberService examRelMemberService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param relId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{relId}")
    public ResponseEntity<ExamRelMember> queryById(@PathVariable("relId") String relId){
        return ResponseEntity.ok(examRelMemberService.queryById(relId));
    }
    
    
    /** 
     * 新增数据
     *
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<ExamRelMember> add(ExamRelMember examRelMember){
        return ResponseEntity.ok(examRelMemberService.insert(examRelMember));
    }
    
    /** 
     * 更新数据
     *
     * @param examRelMember 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<ExamRelMember> edit(ExamRelMember examRelMember){
        return ResponseEntity.ok(examRelMemberService.update(examRelMember));
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param relId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String relId){
        return ResponseEntity.ok(examRelMemberService.deleteById(relId));
    }
}