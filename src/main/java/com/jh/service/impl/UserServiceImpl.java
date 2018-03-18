package com.jh.service.impl;

import com.jh.dao.mapper.UserMapper;
import com.jh.entity.User;
import com.jh.entity.UserExample;
import com.jh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 辉
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers(Integer userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!"".equals(userId == null ? "" : userId)) {
            criteria.andIdEqualTo(userId);
        }
        return userMapper.selectByExample(example);

    }

    @Override
    public List<User> getTimeList() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        return userMapper.getTimeList(example);
    }
    @Override
    public HashMap<Object, Object> getUserList(HashMap<Object, Object> in){
        {
            LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
            map.put("id","1");
            map.put("username","妮可");
            map.put("sex","女");
            map.put("city","深圳");
            map.put("sign","coco");
            map.put("experience","1");
            map.put("logins","1");
            map.put("classify","1");

            ArrayList<Object> list = new ArrayList<Object>();
            list.add(map);
            HashMap<Object, Object > outMap = new HashMap<Object, Object>();
            outMap.put("code", list.size() > 0 ? 0 : 1);
            outMap.put("msg","查询成功");
            outMap.put("count",list.size());
            outMap.put("data", list);

            return outMap;
        }
    }
}
