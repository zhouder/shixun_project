package com.shixun.zb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.shixun.common.annotation.Excel;
import com.shixun.common.core.domain.BaseEntity;

/**
 * 主要焊缝施焊记录子表对象 sj40_detail
 * 
 * @author ruoyi
 * @date 2025-07-18
 */
public class Sj40Detail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联主表ID */
    @Excel(name = "关联主表ID")
    private Long mainId;

    /** 焊缝编号 */
    @Excel(name = "焊缝编号")
    private String hfbh;

    /** 焊道序号 */
    @Excel(name = "焊道序号")
    private String hdxh;

    /** 预热温度(℃) */
    @Excel(name = "预热温度(℃)")
    private Long yrwd;

    /** 层间温度(℃) */
    @Excel(name = "层间温度(℃)")
    private Long cjwd;

    /** 焊接材料 */
    @Excel(name = "焊接材料")
    private String hjcl;

    /** 电流(A) */
    @Excel(name = "电流(A)")
    private Long dl;

    /** 电压(V) */
    @Excel(name = "电压(V)")
    private Long dy;

    /** 车速(m/h) */
    @Excel(name = "车速(m/h)")
    private Long cs;

    /** 焊工编号 */
    @Excel(name = "焊工编号")
    private String hgbh;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date czsj;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMainId(Long mainId) 
    {
        this.mainId = mainId;
    }

    public Long getMainId() 
    {
        return mainId;
    }
    public void setHfbh(String hfbh) 
    {
        this.hfbh = hfbh;
    }

    public String getHfbh() 
    {
        return hfbh;
    }
    public void setHdxh(String hdxh) 
    {
        this.hdxh = hdxh;
    }

    public String getHdxh() 
    {
        return hdxh;
    }
    public void setYrwd(Long yrwd) 
    {
        this.yrwd = yrwd;
    }

    public Long getYrwd() 
    {
        return yrwd;
    }
    public void setCjwd(Long cjwd) 
    {
        this.cjwd = cjwd;
    }

    public Long getCjwd() 
    {
        return cjwd;
    }
    public void setHjcl(String hjcl) 
    {
        this.hjcl = hjcl;
    }

    public String getHjcl() 
    {
        return hjcl;
    }
    public void setDl(Long dl) 
    {
        this.dl = dl;
    }

    public Long getDl() 
    {
        return dl;
    }
    public void setDy(Long dy) 
    {
        this.dy = dy;
    }

    public Long getDy() 
    {
        return dy;
    }
    public void setCs(Long cs) 
    {
        this.cs = cs;
    }

    public Long getCs() 
    {
        return cs;
    }
    public void setHgbh(String hgbh) 
    {
        this.hgbh = hgbh;
    }

    public String getHgbh() 
    {
        return hgbh;
    }
    public void setCzsj(Date czsj) 
    {
        this.czsj = czsj;
    }

    public Date getCzsj() 
    {
        return czsj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainId", getMainId())
            .append("hfbh", getHfbh())
            .append("hdxh", getHdxh())
            .append("yrwd", getYrwd())
            .append("cjwd", getCjwd())
            .append("hjcl", getHjcl())
            .append("dl", getDl())
            .append("dy", getDy())
            .append("cs", getCs())
            .append("hgbh", getHgbh())
            .append("czsj", getCzsj())
            .toString();
    }
}
