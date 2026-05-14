package com.liu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("mybooks")
public class MyBooks {
    private  int id;
    private String username;
    private int bid;
    private Book book;

    public MyBooks(int id, String username, int bid) {
        this.id = id;
        this.username = username;
        this.bid = bid;
    }

}
