package com.ismynr.KasinApp.repository;

import com.ismynr.KasinApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UsersRepo")
public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByIduser(Integer iduser);
    Users findByEmailAndPasswordAndActive(String email, String password, Integer active);

}
