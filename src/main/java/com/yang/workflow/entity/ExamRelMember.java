package com.yang.workflow.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 考核关系表;
 * @author : http://www.chiner.pro
 * @date : 2022-10-16
 */
@ApiModel(value = "考核关系表",description = "")
public class ExamRelMember implements Serializable {
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String relId ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String staffCode ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String staffName ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String checkerCode;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String checkerName ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String examChainCode ;
    /**  */
    @ApiModelProperty(name = "",notes = "null")
    private String examChain ;
     /**  */
     @ApiModelProperty(name = "",notes = "null")
     private String accounting ;

     public String getAccounting() {
         return accounting;
     }

     public void setAccounting(String accounting) {
         this.accounting = accounting;
     }

     /**  */
    public String getRelId(){
        return this.relId;
    }
    /**  */
    public void setRelId(String relId){
        this.relId=relId;
    }
    /**  */
    public String getStaffCode(){
        return this.staffCode;
    }
    /**  */
    public void setStaffCode(String staffCode){
        this.staffCode=staffCode;
    }
    /**  */
    public String getStaffName(){
        return this.staffName;
    }
    /**  */
    public void setStaffName(String staffName){
        this.staffName=staffName;
    }
    /**  */
    public String getCheckerCode(){
        return this.checkerCode;
    }
    /**  */
    public void setCheckerCode(String checkerCode){
        this.checkerCode = checkerCode;
    }
    /**  */
    public String getCheckerName(){
        return this.checkerName;
    }
    /**  */
    public void setCheckerName(String checkerName){
        this.checkerName=checkerName;
    }
    /**  */
    public String getExamChainCode(){
        return this.examChainCode;
    }
    /**  */
    public void setExamChainCode(String examChainCode){
        this.examChainCode=examChainCode;
    }
    /**  */
    public String getExamChain(){
        return this.examChain;
    }
    /**  */
    public void setExamChain(String examChain){
        this.examChain=examChain;
    }
}