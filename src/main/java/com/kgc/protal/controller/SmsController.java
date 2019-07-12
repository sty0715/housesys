package com.kgc.protal.controller;

import com.kgc.sms.SmsUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@RestController
@RequestMapping("/page/")
public class SmsController {
    //向用户发送验证码
    @RequestMapping("getCode")
    public String getCode(String sendPhone,HttpSession session){
        String code=(int)(Math.random()*100000)+"";
        String sendMsg="验证码是:"+code+",请在120秒内输入验证码";
        int i = SmsUtil.sendMsg(sendPhone, sendMsg);
        session.setAttribute("saveCode",code);
        session.setMaxInactiveInterval(120);
        return "{\"result\":"+i+"}";
    }
}
