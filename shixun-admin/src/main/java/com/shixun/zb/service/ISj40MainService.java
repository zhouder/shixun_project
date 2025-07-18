package com.shixun.zb.service;

import java.util.List;
import com.shixun.zb.domain.Sj40Main;

/**
 * 主要焊缝施焊记录主表Service接口
 * 
 * @author ruoyi
 * @date 2025-07-18
 */
public interface ISj40MainService 
{
    /**
     * 查询主要焊缝施焊记录主表
     * 
     * @param id 主要焊缝施焊记录主表主键
     * @return 主要焊缝施焊记录主表
     */
    public Sj40Main selectSj40MainById(Long id);

    /**
     * 查询主要焊缝施焊记录主表列表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 主要焊缝施焊记录主表集合
     */
    public List<Sj40Main> selectSj40MainList(Sj40Main sj40Main);

    /**
     * 新增主要焊缝施焊记录主表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 结果
     */
    public int insertSj40Main(Sj40Main sj40Main);

    /**
     * 修改主要焊缝施焊记录主表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 结果
     */
    public int updateSj40Main(Sj40Main sj40Main);

    /**
     * 批量删除主要焊缝施焊记录主表
     * 
     * @param ids 需要删除的主要焊缝施焊记录主表主键集合
     * @return 结果
     */
    public int deleteSj40MainByIds(Long[] ids);

    /**
     * 删除主要焊缝施焊记录主表信息
     * 
     * @param id 主要焊缝施焊记录主表主键
     * @return 结果
     */
    public int deleteSj40MainById(Long id);
}
