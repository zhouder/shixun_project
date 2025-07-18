package com.shixun.zb.controller;

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
import com.shixun.zb.domain.Sj40Main;
import com.shixun.zb.service.ISj40MainService;
import com.shixun.common.utils.poi.ExcelUtil;
import com.shixun.common.core.page.TableDataInfo;

/**
 * 主要焊缝施焊记录主表Controller
 * 
 * @author ruoyi
 * @date 2025-07-18
 */
@RestController
@RequestMapping("/zbmain/zbmain")
public class Sj40MainController extends BaseController
{
    @Autowired
    private ISj40MainService sj40MainService;

    /**
     * 查询主要焊缝施焊记录主表列表
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sj40Main sj40Main)
    {
        startPage();
        List<Sj40Main> list = sj40MainService.selectSj40MainList(sj40Main);
        return getDataTable(list);
    }

    /**
     * 导出主要焊缝施焊记录主表列表
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:export')")
    @Log(title = "主要焊缝施焊记录主表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sj40Main sj40Main)
    {
        List<Sj40Main> list = sj40MainService.selectSj40MainList(sj40Main);
        ExcelUtil<Sj40Main> util = new ExcelUtil<Sj40Main>(Sj40Main.class);
        util.exportExcel(response, list, "主要焊缝施焊记录主表数据");
    }

    /**
     * 获取主要焊缝施焊记录主表详细信息
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sj40MainService.selectSj40MainById(id));
    }

    /**
     * 新增主要焊缝施焊记录主表
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:add')")
    @Log(title = "主要焊缝施焊记录主表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sj40Main sj40Main)
    {
        return toAjax(sj40MainService.insertSj40Main(sj40Main));
    }

    /**
     * 修改主要焊缝施焊记录主表
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:edit')")
    @Log(title = "主要焊缝施焊记录主表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sj40Main sj40Main)
    {
        return toAjax(sj40MainService.updateSj40Main(sj40Main));
    }

    /**
     * 删除主要焊缝施焊记录主表
     */
    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:remove')")
    @Log(title = "主要焊缝施焊记录主表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sj40MainService.deleteSj40MainByIds(ids));
    }


}
