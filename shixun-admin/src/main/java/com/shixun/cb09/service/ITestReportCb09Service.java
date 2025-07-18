package com.shixun.cb09.service;

import java.util.List;
import com.shixun.cb09.domain.TestReportCb09;

/**
 * 硬化后水泥混凝土性能试验检测报告Service接口
 * 
 * @author wangjian
 * @date 2025-07-10
 */
public interface ITestReportCb09Service 
{
    /**
     * 查询硬化后水泥混凝土性能试验检测报告
     * 
     * @param id 硬化后水泥混凝土性能试验检测报告主键
     * @return 硬化后水泥混凝土性能试验检测报告
     */
    public TestReportCb09 selectTestReportCb09ById(Long id);

    /**
     * 查询硬化后水泥混凝土性能试验检测报告列表
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 硬化后水泥混凝土性能试验检测报告集合
     */
    public List<TestReportCb09> selectTestReportCb09List(TestReportCb09 testReportCb09);

    /**
     * 新增硬化后水泥混凝土性能试验检测报告
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 结果
     */
    public int insertTestReportCb09(TestReportCb09 testReportCb09);

    /**
     * 修改硬化后水泥混凝土性能试验检测报告
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 结果
     */
    public int updateTestReportCb09(TestReportCb09 testReportCb09);

    /**
     * 批量删除硬化后水泥混凝土性能试验检测报告
     * 
     * @param ids 需要删除的硬化后水泥混凝土性能试验检测报告主键集合
     * @return 结果
     */
    public int deleteTestReportCb09ByIds(Long[] ids);

    /**
     * 删除硬化后水泥混凝土性能试验检测报告信息
     * 
     * @param id 硬化后水泥混凝土性能试验检测报告主键
     * @return 结果
     */
    public int deleteTestReportCb09ById(Long id);
}
