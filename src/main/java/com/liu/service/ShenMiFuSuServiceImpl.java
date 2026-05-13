package com.liu.service;

import com.liu.entity.Shenmifusu;
import com.liu.mapper.ShenMiFuSuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShenMiFuSuServiceImpl implements ShenMiFuSuService{
    @Autowired
    private ShenMiFuSuMapper shenMiFuSuMapper;
    @Override
    public Shenmifusu getTitleByID(int id) {
        return shenMiFuSuMapper.selectById(id);
    }
}
