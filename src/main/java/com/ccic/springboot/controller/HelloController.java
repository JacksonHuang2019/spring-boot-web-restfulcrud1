package com.ccic.springboot.controller;

import com.ccic.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @quthor hzs
 * @create 04-17-2020
 * @time 17:09
 * @description 功能描述
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user)  {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello world";
    }

}
