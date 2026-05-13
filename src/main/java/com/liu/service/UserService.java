package com.liu.service;

import com.liu.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserByName(String username);

}
