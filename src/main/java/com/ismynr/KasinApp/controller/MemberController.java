package com.ismynr.KasinApp.controller;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.InRepo;
import com.ismynr.KasinApp.repository.UsersRepo;
import com.ismynr.KasinApp.service.MemberServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private UsersRepo usersRepo;
    @Qualifier("InRepo")
    @Autowired
    private InRepo inrepo;

    @RequestMapping(value = { "/member/dashboard" })
    public String showKasDashboard(Model model, HttpSession session){
        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }
        model.addAttribute("pages", "dashboard");
        return "/member/index";
    }

    @RequestMapping(value = { "/member/kas_masuk" })
    public String showKasMasuk(Model model, HttpSession session){
        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }
        model.addAttribute("pages", "kas_masuk");
        return "/member/pages/kas_masuk";
    }

    @RequestMapping(value = { "/member/kas_keluar" })
    public String showKasKeluar(Model model, HttpSession session){
        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }
        model.addAttribute("pages", "kas_keluar");
        return "/member/pages/kas_keluar";
    }

    @RequestMapping(value = { "/member/laporan" })
    public String showLaporan(Model model, HttpSession session){
        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }
        model.addAttribute("pages", "laporan");
        return "/member/pages/laporan";
    }

    @RequestMapping(value = { "/member/profile" })
    public String showKasProfile(Model model, HttpSession session){
        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }
        model.addAttribute("pages", "profile");
        return "/member/pages/profile";
    }

    @RequestMapping(value = { "/member/**" })
    public String memberIndex(Model model, HttpSession session){

        Users auth = usersRepo.findByIduser((Integer) session.getAttribute("id_user"));
        if(auth == null){
            return "redirect:/";
        }
        if(auth.getId_role() != 2){
            return "redirect:/";
        }

        model.addAttribute("pages", "dashboard");
        return "member/index";
    }
}
