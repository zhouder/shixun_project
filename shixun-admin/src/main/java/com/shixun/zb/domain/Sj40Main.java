package com.shixun.zb.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shixun.common.annotation.Excel;
import com.shixun.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;

/**
 * 主要焊缝施焊记录主表对象 sj40_main
 * 
 * @author ruoyi
 * @date 2025-07-18
 */
public class Sj40Main extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 施工单位 */
    @NotBlank(message = "施工单位不能为空")
    @Excel(name = "施工单位")
    private String sgdw;

    /** 建造单位 */
    @NotBlank(message = "建造单位不能为空")
    @Excel(name = "建造单位")
    private String jzdw;

    /** 监理单位 */
    @NotBlank(message = "监理单位不能为空")
    @Excel(name = "监理单位")
    private String jldw;

    /** 工程名称 */

    @Excel(name = "工程名称")
    private String gcmc;

    /** 合同号 */
    @NotBlank(message = "合同号不能为空")
    @Excel(name = "合同号")
    private String hth;

    /** 编号 */
    @NotBlank(message = "编号不能为空")
    @Excel(name = "编号")
    private String bh;

    /** 工程部位 */
    @Excel(name = "工程部位")
    private String gcbw;

    /** 杆件名称 */
    @Excel(name = "杆件名称")
    private String gjmc;

    /** 杆件编号 */
    @Excel(name = "杆件编号")
    private String gjbh;

    /** 焊接方法 */
    @Excel(name = "焊接方法")
    private String hjff;

    /** 接头形式 */
    @Excel(name = "接头形式")
    private String jtxs;

    /** 环境温度(℃) */
    @Excel(name = "环境温度(℃)")
    private Long hjwd;

    /** 相对湿度(%) */
    @Excel(name = "相对湿度(%)")
    private Long xdsd;

    /** 施工员 */
    @Excel(name = "施工员")
    private String sgy;

    /** 专业工程师 */
    @Excel(name = "专业工程师")
    private String zygcs;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cjsj;

    /** 获取用户名 */
    @Excel(name = "用户名")
    private String userid;

    /** 获取位置 */
    @Excel(name = "位置")
    private String postion;

    /** 主要焊缝施焊记录子表信息 */
    private List<Sj40Detail> sj40DetailList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSgdw(String sgdw) 
    {
        this.sgdw = sgdw;
    }

    public String getSgdw() 
    {
        return sgdw;
    }
    public void setJzdw(String jzdw) 
    {
        this.jzdw = jzdw;
    }

    public String getJzdw() 
    {
        return jzdw;
    }
    public void setJldw(String jldw) 
    {
        this.jldw = jldw;
    }

    public String getJldw() 
    {
        return jldw;
    }
    public void setGcmc(String gcmc) 
    {
        this.gcmc = gcmc;
    }

    public String getGcmc() 
    {
        return gcmc;
    }
    public void setHth(String hth) 
    {
        this.hth = hth;
    }

    public String getHth() 
    {
        return hth;
    }
    public void setBh(String bh) 
    {
        this.bh = bh;
    }

    public String getBh() 
    {
        return bh;
    }
    public void setGcbw(String gcbw) 
    {
        this.gcbw = gcbw;
    }

    public String getGcbw() 
    {
        return gcbw;
    }
    public void setGjmc(String gjmc) 
    {
        this.gjmc = gjmc;
    }

    public String getGjmc() 
    {
        return gjmc;
    }
    public void setGjbh(String gjbh) 
    {
        this.gjbh = gjbh;
    }

    public String getGjbh() 
    {
        return gjbh;
    }
    public void setHjff(String hjff) 
    {
        this.hjff = hjff;
    }

    public String getHjff() 
    {
        return hjff;
    }
    public void setJtxs(String jtxs) 
    {
        this.jtxs = jtxs;
    }

    public String getJtxs() 
    {
        return jtxs;
    }
    public void setHjwd(Long hjwd) 
    {
        this.hjwd = hjwd;
    }

    public Long getHjwd() 
    {
        return hjwd;
    }
    public void setXdsd(Long xdsd) 
    {
        this.xdsd = xdsd;
    }

    public Long getXdsd() 
    {
        return xdsd;
    }
    public void setSgy(String sgy) 
    {
        this.sgy = sgy;
    }

    public String getSgy() 
    {
        return sgy;
    }
    public void setZygcs(String zygcs) 
    {
        this.zygcs = zygcs;
    }

    public String getZygcs() 
    {
        return zygcs;
    }
    public void setCjsj(Date cjsj) 
    {
        this.cjsj = cjsj;
    }

    public Date getCjsj() 
    {
        return cjsj;
    }

    public void setUserId(String userid){
        this.userid=userid;
    }

    public String getUserId(){
        return userid;
    }


    public List<Sj40Detail> getSj40DetailList()
    {
        return sj40DetailList;
    }

    public void setSj40DetailList(List<Sj40Detail> sj40DetailList)
    {
        this.sj40DetailList = sj40DetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sgdw", getSgdw())
            .append("jzdw", getJzdw())
            .append("jldw", getJldw())
            .append("gcmc", getGcmc())
            .append("hth", getHth())
            .append("bh", getBh())
            .append("gcbw", getGcbw())
            .append("gjmc", getGjmc())
            .append("gjbh", getGjbh())
            .append("hjff", getHjff())
            .append("jtxs", getJtxs())
            .append("hjwd", getHjwd())
            .append("xdsd", getXdsd())
            .append("sgy", getSgy())
            .append("zygcs", getZygcs())
            .append("cjsj", getCjsj())
            .append("userid", getUserId())
            .append("sj40DetailList", getSj40DetailList())
            .toString();
    }
}
