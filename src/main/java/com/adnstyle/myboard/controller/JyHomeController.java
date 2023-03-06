package com.adnstyle.myboard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@SessionAttributes("jyUserSession")
public class JyHomeController {
    
    /**
     * 메인화면이자 로그인 성공시 기본경로
     */
    @GetMapping("/")
    public String jyHome() {
        
        log.debug("메인화면 접속");

        return "jyHome";
    }
    
    
    @GetMapping("/sessionTest")
    public String Test(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if(session == null){
            System.out.println("세션이 없습니다.");
        }
        long time = session.getLastAccessedTime()-session.getCreationTime();
    
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getCreationTime());//생성된시간
        System.out.println(session.getLastAccessedTime());//마지막 접근시간
        System.out.println("세션 잔여시간 : "+time);
    
        return "jyHome";
    }
    
    @PostMapping("/sessionAdd")
    @ResponseBody
    public void sessionAdd(){
        log.info("세션연장");
    }

}
