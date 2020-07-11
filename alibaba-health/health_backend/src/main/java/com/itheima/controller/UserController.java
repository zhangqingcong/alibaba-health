package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 通过框架获取用户名
     * @return
     */

    @RequestMapping("/getUsername")
    public Result getUsername(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> list = new ArrayList<>();
            Iterator<String> iterator = list.iterator();

            return  new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.GET_USERNAME_FAIL);
        }

    }
}
