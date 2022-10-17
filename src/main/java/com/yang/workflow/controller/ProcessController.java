package com.yang.workflow.controller;

import com.yang.workflow.entity.ExamRelMember;
import com.yang.workflow.service.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/exam")
@Api(tags = "考核流程")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("/getController")
    @ApiOperation("swagger测试接口")
    public String testSwagger() {
        return "swagger访问成功";
    }


    @RequestMapping("/starExamStaff")
    @ApiOperation("swagger测试接口")
    public String startExam(String relId) {
        return processService.startExam(relId);
    }

}
