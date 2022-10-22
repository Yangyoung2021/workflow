package com.yang.workflow.controller;

import com.yang.workflow.service.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @GetMapping("/starExamStaff")
    @ApiOperation("启动考核流程")
    public String startExam(String relId) {
        return processService.startExam(relId);
    }

    @GetMapping("/viewTodo")
    @ApiOperation("查看代办")
    public List<String> viewTodo(String staffCode) {
        return processService.viewTodo(staffCode);
    }

    @GetMapping("/staffComplete")
    @ApiOperation("通过关系id完成任务")
    public String staffComplete(String relId) {
        return processService.staffComplete(relId);
    }

    @GetMapping("/checkerExam")
    @ApiOperation("考核人考核")
    public String checkerExam(String relId) {
        return processService.checkerExamComplete(relId);
    }

    @GetMapping("/viewCurrentProcess")
    @ApiOperation("查看流程具体的情况")
    public List<String> viewCurrentProcess(String relId) {
        return processService.viewCurrentProcess(relId);
    }

}
