package com.ccic.springboot.exception;/**
 * @quthor hzs
 * @create 04-17-2020
 * @time 17:03
 * @description 功能描述
 */

public class UserNotExistException  extends  RuntimeException{

    public UserNotExistException() {
        super("用户不存在！");
    }


}
