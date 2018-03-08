package com.jh.controller;

import com.jh.common.GenericController;
import com.jh.dao.mapper.UserMapper;
import com.jh.entity.User;
import com.jh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 辉
 */
@Controller
@RequestMapping(value = "/timelist")
public class TimeListController extends GenericController{
    @Autowired
    UserService userService;
    @RequestMapping (value = "/getTimeList" ,method = RequestMethod.GET)
    @ResponseBody
        public List getTimeList(@RequestParam  String id, HttpServletResponse response, HttpServletRequest request){
        List<User> timeList = userService.getTimeList();
        System.out.println(timeList.toString());
        System.out.println("查询时间列表成功,id:" + id);

            return timeList;
        }

}
