package com.jh.service;

import com.jh.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    List<User> getUsers(Integer userId);
    List<User> getTimeList();
    HashMap<Object,Object> getUserList(HashMap<Object,Object> in);
}
