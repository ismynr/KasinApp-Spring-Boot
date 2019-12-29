package com.ismynr.KasinApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping(value = {"/logout"})
    public String logout(Model model, HttpSession session){
        if(session.getAttribute("id_user") != null){
            session.removeAttribute("id_user");
            session.removeAttribute("nama");
            session.invalidate();

            model.addAttribute("flashMod", "alert alert-success");
            model.addAttribute("flashMsg", "Anda berhasil logout");
            return "pages/login";
        }
        return "redirect:/";
    }
}
