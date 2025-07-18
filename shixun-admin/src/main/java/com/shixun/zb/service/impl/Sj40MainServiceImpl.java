package com.shixun.zb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.shixun.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.shixun.zb.domain.Sj40Detail;
import com.shixun.zb.mapper.Sj40MainMapper;
import com.shixun.zb.domain.Sj40Main;
import com.shixun.zb.service.ISj40MainService;

/**
 * 主要焊缝施焊记录主表Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-18
 */
@Service
public class Sj40MainServiceImpl implements ISj40MainService 
{
    @Autowired
    private Sj40MainMapper sj40MainMapper;

    /**
     * 查询主要焊缝施焊记录主表
     * 
     * @param id 主要焊缝施焊记录主表主键
     * @return 主要焊缝施焊记录主表
     */
    @Override
    public Sj40Main selectSj40MainById(Long id)
    {
        return sj40MainMapper.selectSj40MainById(id);
    }

    /**
     * 查询主要焊缝施焊记录主表列表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 主要焊缝施焊记录主表
     */
    @Override
    public List<Sj40Main> selectSj40MainList(Sj40Main sj40Main)
    {
        return sj40MainMapper.selectSj40MainList(sj40Main);
    }

    /**
     * 新增主要焊缝施焊记录主表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSj40Main(Sj40Main sj40Main)
    {
        int rows = sj40MainMapper.insertSj40Main(sj40Main);
        insertSj40Detail(sj40Main);
        return rows;
    }

    /**
     * 修改主要焊缝施焊记录主表
     * 
     * @param sj40Main 主要焊缝施焊记录主表
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSj40Main(Sj40Main sj40Main)
    {
        sj40MainMapper.deleteSj40DetailByMainId(sj40Main.getId());
        insertSj40Detail(sj40Main);
        return sj40MainMapper.updateSj40Main(sj40Main);
    }

    /**
     * 批量删除主要焊缝施焊记录主表
     * 
     * @param ids 需要删除的主要焊缝施焊记录主表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSj40MainByIds(Long[] ids)
    {
        sj40MainMapper.deleteSj40DetailByMainIds(ids);
        return sj40MainMapper.deleteSj40MainByIds(ids);
    }

    /**
     * 删除主要焊缝施焊记录主表信息
     * 
     * @param id 主要焊缝施焊记录主表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSj40MainById(Long id)
    {
        sj40MainMapper.deleteSj40DetailByMainId(id);
        return sj40MainMapper.deleteSj40MainById(id);
    }

    /**
     * 新增主要焊缝施焊记录子表信息
     * 
     * @param sj40Main 主要焊缝施焊记录主表对象
     */
    public void insertSj40Detail(Sj40Main sj40Main)
    {
        List<Sj40Detail> sj40DetailList = sj40Main.getSj40DetailList();
        Long id = sj40Main.getId();
        if (StringUtils.isNotNull(sj40DetailList))
        {
            List<Sj40Detail> list = new ArrayList<Sj40Detail>();
            for (Sj40Detail sj40Detail : sj40DetailList)
            {
                sj40Detail.setMainId(id);
                list.add(sj40Detail);
            }
            if (list.size() > 0)
            {
                sj40MainMapper.batchSj40Detail(list);
            }
        }
    }
}
