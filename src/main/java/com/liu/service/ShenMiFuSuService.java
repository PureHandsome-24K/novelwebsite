package com.liu.service;

import com.liu.entity.Shenmifusu;
import org.springframework.stereotype.Service;

@Service
public interface ShenMiFuSuService {
    Shenmifusu getTitleByID(int id);
}
