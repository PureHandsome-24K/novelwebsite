package com.liu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Select("select * from book where dir=#{dir}")
    Book getBookByDir(String dir);

    Book getbookbyid(int id);

    @Select("select * from book where title= #{title}")
    Book getbooktitle(String title);

}
