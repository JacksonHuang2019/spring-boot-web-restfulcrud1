package com.ccic.springboot.controller;

import com.ccic.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @quthor hzs
 * @create 04-17-2020
 * @time 17:34
 * @description 功能描述
 */

// 异常处理器
@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("code", "user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 传入自己的状态码 否则不进入自定义错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message","用户出错了！");
        map.put("ext", map);
        return "forward:/error ";
    }
}
