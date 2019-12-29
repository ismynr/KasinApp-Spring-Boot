package com.ismynr.KasinApp.controller;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import com.ismynr.KasinApp.util.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UsersRepo usersRepo ;

    @RequestMapping(value = "/login/auth", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("Users") Users users, HttpSession session) {

        if ( users.getEmail() != null && users.getPassword() != null ) {
            String passCrypt = Crypt.encrypt(users.getPassword());
            Users isCorrect = usersRepo.findByEmailAndPasswordAndActive(users.getEmail(), passCrypt, 1);

            if ( isCorrect != null ) {
                session.setAttribute("id_user", isCorrect.getIduser());
                session.setAttribute("nama", isCorrect.getNama());
                switch ( isCorrect.getId_role() ){
                    case 1:
                        return "redirect:/admin";
                    case 2:
                        return "redirect:/member";
                    default:
                        model.addAttribute("flashMod", "alert alert-danger");
                        model.addAttribute("flashMsg", "Anda tidak berada di user manapun");
                        return "pages/login";
                }
            } else {
                model.addAttribute("flashMod", "alert alert-danger");
                model.addAttribute("flashMsg", "Email dan password tidak ada");
                return "pages/login";
            }
        } else {
            model.addAttribute("flashMod", "alert alert-danger");
            model.addAttribute("flashMsg", "Mohon masukan email dan password");
            return "pages/login";
        }
    }
}
