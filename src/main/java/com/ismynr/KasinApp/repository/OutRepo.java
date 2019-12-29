package com.ismynr.KasinApp.repository;

import com.ismynr.KasinApp.entity.Out;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("OutRepo")
public interface OutRepo extends JpaRepository<Out, String> {
    List<Out> findByIdUser(Integer idUser);
}
