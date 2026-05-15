package com.liu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.MyBooks;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyBooksMapper extends BaseMapper<MyBooks> {
    List<MyBooks> queryMybooks(String username);
    @Select("SELECT * FROM mybooks WHERE username=#{username} AND bid=#{bid}")
    MyBooks getmybooks(String username, int bid);
    @Delete("DELETE FROM mybooks WHERE username=#{username} AND bid=#{bid}")
    int deleteMybooks(String username, int bid);
}
