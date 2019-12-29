package com.ismynr.KasinApp.service_impl;

import com.ismynr.KasinApp.entity.Users;
import com.ismynr.KasinApp.repository.UsersRepo;
import com.ismynr.KasinApp.service.UsersServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UsersServ")
public class UsersServImpl implements UsersServ {

    @Qualifier("UsersRepo")
    @Autowired
    private UsersRepo userrepo;

    @Override
    public Users getUsersById(Integer id_user) {
        return userrepo.getOne(id_user);
    }

    @Override
    public Users updateUsers(Integer id_user, Users user){
        userrepo.getOne(id_user);
        return userrepo.save(user);
    }
}
