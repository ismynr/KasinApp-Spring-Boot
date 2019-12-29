package com.ismynr.KasinApp.controller;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import com.ismynr.KasinApp.util.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {
    @Qualifier("UsersRepo")
    @Autowired
    private UsersRepo usersrepo;

    @RequestMapping(value = "/register/auth", method = RequestMethod.POST)
    public String register(@ModelAttribute("usersobject") Users users, Model model){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String passCrypt = Crypt.encrypt(users.getPassword());
        users.setPassword(passCrypt);
        users.setId_role(2);
        users.setActive(1);
        users.setCreated_at(dateFormat.format(date));
        usersrepo.save(users);
        model.addAttribute("flashMod", "alert alert-success");
        model.addAttribute("flashMsg", "Berhasil daftar, silahkan login!");
        return "pages/login";
    }
}
