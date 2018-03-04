package com.jh.service;

import com.jh.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(Integer userId);
}
