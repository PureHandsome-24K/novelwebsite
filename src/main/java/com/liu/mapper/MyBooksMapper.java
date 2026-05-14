package com.liu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.MyBooks;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyBooksMapper extends BaseMapper<MyBooks> {
    List<MyBooks> queryMybooks(String username);

}
