package com.shixun.cb09.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shixun.common.annotation.Log;
import com.shixun.common.core.controller.BaseController;
import com.shixun.common.core.domain.AjaxResult;
import com.shixun.common.enums.BusinessType;
import com.shixun.cb09.domain.TestReportCb09;
import com.shixun.cb09.service.ITestReportCb09Service;
import com.shixun.common.utils.poi.ExcelUtil;
import com.shixun.common.core.page.TableDataInfo;

/**
 * 硬化后水泥混凝土性能试验检测报告Controller
 * 
 * @author wangjian
 * @date 2025-07-10
 */
@RestController
@RequestMapping("/cb09/cb09")
public class TestReportCb09Controller extends BaseController
{
    @Autowired
    private ITestReportCb09Service testReportCb09Service;

    /**
     * 查询硬化后水泥混凝土性能试验检测报告列表
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestReportCb09 testReportCb09)
    {
        startPage();
        List<TestReportCb09> list = testReportCb09Service.selectTestReportCb09List(testReportCb09);
        return getDataTable(list);
    }

    /**
     * 导出硬化后水泥混凝土性能试验检测报告列表
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:export')")
    @Log(title = "硬化后水泥混凝土性能试验检测报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestReportCb09 testReportCb09)
    {
        List<TestReportCb09> list = testReportCb09Service.selectTestReportCb09List(testReportCb09);
        ExcelUtil<TestReportCb09> util = new ExcelUtil<TestReportCb09>(TestReportCb09.class);
        util.exportExcel(response, list, "硬化后水泥混凝土性能试验检测报告数据");
    }

    /**
     * 获取硬化后水泥混凝土性能试验检测报告详细信息
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testReportCb09Service.selectTestReportCb09ById(id));
    }

    /**
     * 新增硬化后水泥混凝土性能试验检测报告
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:add')")
    @Log(title = "硬化后水泥混凝土性能试验检测报告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestReportCb09 testReportCb09)
    {
        return toAjax(testReportCb09Service.insertTestReportCb09(testReportCb09));
    }

    /**
     * 修改硬化后水泥混凝土性能试验检测报告
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:edit')")
    @Log(title = "硬化后水泥混凝土性能试验检测报告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestReportCb09 testReportCb09)
    {
        return toAjax(testReportCb09Service.updateTestReportCb09(testReportCb09));
    }

    /**
     * 删除硬化后水泥混凝土性能试验检测报告
     */
    @PreAuthorize("@ss.hasPermi('cb09:cb09:remove')")
    @Log(title = "硬化后水泥混凝土性能试验检测报告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testReportCb09Service.deleteTestReportCb09ByIds(ids));
    }
}
