package com.ismynr.KasinApp.controller.member;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.service.UsersServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member/api")
public class UsersRestController {
    @Qualifier("UsersServ")
    @Autowired
    private UsersServ usersserv;

    //    GET DATA BY KODE PENGELUARAN
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public Users getOutById(@PathVariable("id") Integer id){
        return usersserv.getUsersById(id);
    }

    //    UPDATE PROFILE
    @PutMapping(value = "profile/{kode}")
    public ResponseEntity<Users> restUpdateIn(@PathVariable(value = "kode") Integer id, @Validated @RequestBody Users dataUsers){
        Users user = usersserv.getUsersById(id);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        //Set data modified
        user.setNama(dataUsers.getNama());
        user.setEmail(dataUsers.getEmail());
        return ResponseEntity.ok(usersserv.updateUsers(id, user));
    }
}
