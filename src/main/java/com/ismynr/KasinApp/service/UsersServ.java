package com.ismynr.KasinApp.service;

import com.ismynr.KasinApp.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersServ {
    public Users getUsersById(Integer iduser);
    public Users updateUsers(Integer iduser, Users user);
}
