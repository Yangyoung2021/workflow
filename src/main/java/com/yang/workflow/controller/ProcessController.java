package com.yang.workflow.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/exam")
@Api(tags = "考核流程")
public class ProcessController {

    @GetMapping("/getController")
    @ApiOperation("swagger测试接口")
    public String testSwagger() {
        return "swagger访问成功";
    }

}
