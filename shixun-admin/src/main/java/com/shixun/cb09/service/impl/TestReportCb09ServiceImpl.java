package com.shixun.cb09.service.impl;

import java.util.List;
import com.shixun.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shixun.cb09.mapper.TestReportCb09Mapper;
import com.shixun.cb09.domain.TestReportCb09;
import com.shixun.cb09.service.ITestReportCb09Service;

/**
 * 硬化后水泥混凝土性能试验检测报告Service业务层处理
 * 
 * @author wangjian
 * @date 2025-07-10
 */
@Service
public class TestReportCb09ServiceImpl implements ITestReportCb09Service 
{
    @Autowired
    private TestReportCb09Mapper testReportCb09Mapper;

    /**
     * 查询硬化后水泥混凝土性能试验检测报告
     * 
     * @param id 硬化后水泥混凝土性能试验检测报告主键
     * @return 硬化后水泥混凝土性能试验检测报告
     */
    @Override
    public TestReportCb09 selectTestReportCb09ById(Long id)
    {
        return testReportCb09Mapper.selectTestReportCb09ById(id);
    }

    /**
     * 查询硬化后水泥混凝土性能试验检测报告列表
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 硬化后水泥混凝土性能试验检测报告
     */
    @Override
    public List<TestReportCb09> selectTestReportCb09List(TestReportCb09 testReportCb09)
    {
        return testReportCb09Mapper.selectTestReportCb09List(testReportCb09);
    }

    /**
     * 新增硬化后水泥混凝土性能试验检测报告
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 结果
     */
    @Override
    public int insertTestReportCb09(TestReportCb09 testReportCb09)
    {
        testReportCb09.setCreateTime(DateUtils.getNowDate());
        return testReportCb09Mapper.insertTestReportCb09(testReportCb09);
    }

    /**
     * 修改硬化后水泥混凝土性能试验检测报告
     * 
     * @param testReportCb09 硬化后水泥混凝土性能试验检测报告
     * @return 结果
     */
    @Override
    public int updateTestReportCb09(TestReportCb09 testReportCb09)
    {
        testReportCb09.setUpdateTime(DateUtils.getNowDate());
        return testReportCb09Mapper.updateTestReportCb09(testReportCb09);
    }

    /**
     * 批量删除硬化后水泥混凝土性能试验检测报告
     * 
     * @param ids 需要删除的硬化后水泥混凝土性能试验检测报告主键
     * @return 结果
     */
    @Override
    public int deleteTestReportCb09ByIds(Long[] ids)
    {
        return testReportCb09Mapper.deleteTestReportCb09ByIds(ids);
    }

    /**
     * 删除硬化后水泥混凝土性能试验检测报告信息
     * 
     * @param id 硬化后水泥混凝土性能试验检测报告主键
     * @return 结果
     */
    @Override
    public int deleteTestReportCb09ById(Long id)
    {
        return testReportCb09Mapper.deleteTestReportCb09ById(id);
    }
}
