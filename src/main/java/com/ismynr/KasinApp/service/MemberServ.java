package com.ismynr.KasinApp.service;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServ {
    @Autowired
    private UsersRepo usersRepo;

    public boolean ensureMember(Users auth) {
        if(auth == null){
            return false;
        }
        if(auth.getId_role() != 2){
            return false;
        }

        return true;
//        return true;
//        if(session.getAttribute("id_user") != null){
//            Users auth = usersRepo.findByIduser((int)session.getAttribute("id_user"));
//            return auth.getId_role() == 2;
//        }else{
//            return false;
//        }

//        Users auth = usersRepo.findByIduser(2);
//        if(auth != null){
//            if(auth.getId_role() == 2){
////                model.addAttribute("flashMsg", true);
////                return "pages/login";
//                return true;
//            }else{
////                model.addAttribute("flashMsg", false);
////                return "pages/login";
//                return false;
//            }
//        }else{
////            model.addAttribute("flashMsg", "kosong");
////            return "pages/login";
//            return false;
//        }
    }
}