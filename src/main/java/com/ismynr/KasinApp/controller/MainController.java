package com.ismynr.KasinApp.controller;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    private UsersRepo usersRepo;

    @RequestMapping(value = { "/", "/index" })
    public String index(Model model){
        model.addAttribute("pages", "Home");
        return "index";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String showLoginForm(Model model, HttpSession session){

        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(session.getAttribute("id_user") != null){
            switch (auth.getId_role()){
                case 1:
                    return "redirect:/admin";
                case 2:
                    return "redirect:/member";
                default:
                    return "redirect:/";
            }
        }

        model.addAttribute("pages", "Login");
        return "pages/login";
    }

    @RequestMapping(value = { "/register" })
    public String showRegisterForm(Model model, HttpSession session){

        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(session.getAttribute("id_user") != null){
            switch (auth.getId_role()){
                case 1:
                    return "redirect:/admin";
                case 2:
                    return "redirect:/member";
                default:
                    return "redirect:/";
            }
        }

        model.addAttribute("usersobject", new Users());
        model.addAttribute("pages", "Register");
        return "pages/register";
    }
}
