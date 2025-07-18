package com.shixun.cb09.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shixun.common.annotation.Excel;
import com.shixun.common.core.domain.BaseEntity;

/**
 * 硬化后水泥混凝土性能试验检测报告对象 test_report_cb09
 * 
 * @author wangjian
 * @date 2025-07-10
 */
public class TestReportCb09 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 检测单位名称 */
    @Excel(name = "检测单位名称")
    private String testOrgName;

    /** 报告编号 */
    private String reportNo;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String projectName;

    /** 合同段 */
    private String contractArea;

    /** 施工单位 */
    private String constructionOrgName;

    /** 监理单位 */
    private String supervisorOrgName;

    /** 工程部位/用途 */
    private String projectPartAndPurpose;

    /** 样品信息 */
    private String sampleInfo;

    /** 检测依据 */
    private String testingBasis;

    /** 判定依据 */
    private String judgmentCriteria;

    /** 主要仪器设备名称和编号 */
    private String equipmentNameAndNo;

    /** 配合比编号 */
    private String mixProportionNo;

    /** 设计抗渗等级 */
    private String impermeabilityLevel;

    /** 设计强度(MPa) */
    private String designStrength;

    /** 搅拌方式 */
    private String stirType;

    /** 成型日期 */
    private Date formingDate;

    /** 坍落度 */
    private BigDecimal slumpsValue;

    /** 养护方式 */
    private String maintainType;

    /** 龄期(d) */
    private Long ageValue;

    /** 试验日期 */
    private Date testDate;

    /** 组号 */
    private String teamNo;

    /** 检测停止时的水压力(MPa) */
    private BigDecimal testStopWaterPressure;

    /** 检测停止时的渗水试件的数量（个） */
    private Long testStopSeepagePartNum;

    /** 实测抗渗等级 */
    private String testStrength;

    /** 结论 */
    @Excel(name = "结论")
    private String result;

    /** 附加声明 */
    private String additionalStatement;

    /** 检测 */
    private String testPerson;

    /** 审核 */
    private String examinePerson;

    /** 批准 */
    private String approvePerson;

    /** 日期 */
    private Date reportDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTestOrgName(String testOrgName) 
    {
        this.testOrgName = testOrgName;
    }

    public String getTestOrgName() 
    {
        return testOrgName;
    }
    public void setReportNo(String reportNo) 
    {
        this.reportNo = reportNo;
    }

    public String getReportNo() 
    {
        return reportNo;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setContractArea(String contractArea) 
    {
        this.contractArea = contractArea;
    }

    public String getContractArea() 
    {
        return contractArea;
    }
    public void setConstructionOrgName(String constructionOrgName) 
    {
        this.constructionOrgName = constructionOrgName;
    }

    public String getConstructionOrgName() 
    {
        return constructionOrgName;
    }
    public void setSupervisorOrgName(String supervisorOrgName) 
    {
        this.supervisorOrgName = supervisorOrgName;
    }

    public String getSupervisorOrgName() 
    {
        return supervisorOrgName;
    }
    public void setProjectPartAndPurpose(String projectPartAndPurpose) 
    {
        this.projectPartAndPurpose = projectPartAndPurpose;
    }

    public String getProjectPartAndPurpose() 
    {
        return projectPartAndPurpose;
    }
    public void setSampleInfo(String sampleInfo) 
    {
        this.sampleInfo = sampleInfo;
    }

    public String getSampleInfo() 
    {
        return sampleInfo;
    }
    public void setTestingBasis(String testingBasis) 
    {
        this.testingBasis = testingBasis;
    }

    public String getTestingBasis() 
    {
        return testingBasis;
    }
    public void setJudgmentCriteria(String judgmentCriteria) 
    {
        this.judgmentCriteria = judgmentCriteria;
    }

    public String getJudgmentCriteria() 
    {
        return judgmentCriteria;
    }
    public void setEquipmentNameAndNo(String equipmentNameAndNo) 
    {
        this.equipmentNameAndNo = equipmentNameAndNo;
    }

    public String getEquipmentNameAndNo() 
    {
        return equipmentNameAndNo;
    }
    public void setMixProportionNo(String mixProportionNo) 
    {
        this.mixProportionNo = mixProportionNo;
    }

    public String getMixProportionNo() 
    {
        return mixProportionNo;
    }
    public void setImpermeabilityLevel(String impermeabilityLevel) 
    {
        this.impermeabilityLevel = impermeabilityLevel;
    }

    public String getImpermeabilityLevel() 
    {
        return impermeabilityLevel;
    }
    public void setDesignStrength(String designStrength) 
    {
        this.designStrength = designStrength;
    }

    public String getDesignStrength() 
    {
        return designStrength;
    }
    public void setStirType(String stirType) 
    {
        this.stirType = stirType;
    }

    public String getStirType() 
    {
        return stirType;
    }
    public void setFormingDate(Date formingDate) 
    {
        this.formingDate = formingDate;
    }

    public Date getFormingDate() 
    {
        return formingDate;
    }
    public void setSlumpsValue(BigDecimal slumpsValue) 
    {
        this.slumpsValue = slumpsValue;
    }

    public BigDecimal getSlumpsValue() 
    {
        return slumpsValue;
    }
    public void setMaintainType(String maintainType) 
    {
        this.maintainType = maintainType;
    }

    public String getMaintainType() 
    {
        return maintainType;
    }
    public void setAgeValue(Long ageValue) 
    {
        this.ageValue = ageValue;
    }

    public Long getAgeValue() 
    {
        return ageValue;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setTeamNo(String teamNo) 
    {
        this.teamNo = teamNo;
    }

    public String getTeamNo() 
    {
        return teamNo;
    }
    public void setTestStopWaterPressure(BigDecimal testStopWaterPressure) 
    {
        this.testStopWaterPressure = testStopWaterPressure;
    }

    public BigDecimal getTestStopWaterPressure() 
    {
        return testStopWaterPressure;
    }
    public void setTestStopSeepagePartNum(Long testStopSeepagePartNum) 
    {
        this.testStopSeepagePartNum = testStopSeepagePartNum;
    }

    public Long getTestStopSeepagePartNum() 
    {
        return testStopSeepagePartNum;
    }
    public void setTestStrength(String testStrength) 
    {
        this.testStrength = testStrength;
    }

    public String getTestStrength() 
    {
        return testStrength;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setAdditionalStatement(String additionalStatement) 
    {
        this.additionalStatement = additionalStatement;
    }

    public String getAdditionalStatement() 
    {
        return additionalStatement;
    }
    public void setTestPerson(String testPerson) 
    {
        this.testPerson = testPerson;
    }

    public String getTestPerson() 
    {
        return testPerson;
    }
    public void setExaminePerson(String examinePerson) 
    {
        this.examinePerson = examinePerson;
    }

    public String getExaminePerson() 
    {
        return examinePerson;
    }
    public void setApprovePerson(String approvePerson) 
    {
        this.approvePerson = approvePerson;
    }

    public String getApprovePerson() 
    {
        return approvePerson;
    }
    public void setReportDate(Date reportDate) 
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate() 
    {
        return reportDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("testOrgName", getTestOrgName())
            .append("reportNo", getReportNo())
            .append("projectName", getProjectName())
            .append("contractArea", getContractArea())
            .append("constructionOrgName", getConstructionOrgName())
            .append("supervisorOrgName", getSupervisorOrgName())
            .append("projectPartAndPurpose", getProjectPartAndPurpose())
            .append("sampleInfo", getSampleInfo())
            .append("testingBasis", getTestingBasis())
            .append("judgmentCriteria", getJudgmentCriteria())
            .append("equipmentNameAndNo", getEquipmentNameAndNo())
            .append("mixProportionNo", getMixProportionNo())
            .append("impermeabilityLevel", getImpermeabilityLevel())
            .append("designStrength", getDesignStrength())
            .append("stirType", getStirType())
            .append("formingDate", getFormingDate())
            .append("slumpsValue", getSlumpsValue())
            .append("maintainType", getMaintainType())
            .append("ageValue", getAgeValue())
            .append("testDate", getTestDate())
            .append("teamNo", getTeamNo())
            .append("testStopWaterPressure", getTestStopWaterPressure())
            .append("testStopSeepagePartNum", getTestStopSeepagePartNum())
            .append("testStrength", getTestStrength())
            .append("result", getResult())
            .append("additionalStatement", getAdditionalStatement())
            .append("testPerson", getTestPerson())
            .append("examinePerson", getExaminePerson())
            .append("approvePerson", getApprovePerson())
            .append("reportDate", getReportDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
