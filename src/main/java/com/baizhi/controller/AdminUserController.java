package com.baizhi.controller;

import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminuser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("login")
    public String login(AdminUser adminUser, String enCode, HttpSession session){
        String code = (String) session.getAttribute("code");
        if(code!=null&&enCode!=null&&enCode.equalsIgnoreCase(code)){
            System.out.println(adminUser);
            AdminUser user = adminUserService.loginAdmin(adminUser);
            if(user!=null){
                session.setAttribute("adminuser",user);
                return "redirect:/main/main.jsp";
            }
        }
        return "login";
    }
}
