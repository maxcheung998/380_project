/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.controller;

import com.ouhk.webforum.dao.ForumUserRepository;
import com.ouhk.webforum.model.ForumUser;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    
    @Resource
    ForumUserRepository forumUserRepo;

    @GetMapping
    public String index() {
        return "redirect:/categories/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
      public static class RegisterForm {
        private String username;
        private String email;
        private String password;
        private String cpassword;
        private Integer status = 0;
        private String[] roles;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCpassword() {
            return cpassword;
        }

        public void setCpassword(String cpassword) {
            this.cpassword = cpassword;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }
        
      
      }
    
    
    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "registerForm", new RegisterForm());
    }
//        
    @PostMapping("/register")
    public View register(RegisterForm form) throws IOException {
        if (form.getPassword().equals(form.getCpassword())) {
            ForumUser user = new ForumUser(form.getUsername(), 
                form.getPassword(), form.getRoles()
            );
            forumUserRepo.save(user);
            return new RedirectView("/login", true);
            //connect to database.
        } else {
            return new RedirectView("/register?error", true);
            //connect to database.
        }
    }
}
