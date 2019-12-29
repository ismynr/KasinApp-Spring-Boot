package com.ismynr.KasinApp.controller;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private UsersRepo usersRepo;

    @RequestMapping(value = { "/admin" })
    public String memberIndex(Model model, HttpSession session){

        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 1){
            return "redirect:/";
        }

        model.addAttribute("pages", "dashboard");
        return "admin/index";
    }
}
