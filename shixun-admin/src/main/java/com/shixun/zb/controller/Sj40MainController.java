package com.shixun.zb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PreAuthorize("@ss.hasPermi('zbmain:zbmain:export')")
    @GetMapping
    public AjaxResult exportEasyExcel(@RequestParam Long id)
    {
        String templateFileName = "D:\\shixun\\myexcel\\template.xlsx";

        String fileName = "D:\\shixun\\myexcel\\" + "exportTable" + System.currentTimeMillis() + ".xlsx";

        Sj40Main sj40Main = sj40MainService.selectSj40MainById(id);

        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.VERTICAL).build();

        try(ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.fill(sj40Main, writeSheet);
            excelWriter.fill(new FillWrapper("sj40DetailList", sj40Main.getSj40DetailList()), fillConfig, writeSheet);
        }
        return success();
    }

}
