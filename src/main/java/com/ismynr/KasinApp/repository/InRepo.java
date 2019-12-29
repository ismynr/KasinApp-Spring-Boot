package com.ismynr.KasinApp.repository;

import com.ismynr.KasinApp.entity.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InRepo")
public interface InRepo extends JpaRepository<In, String> {
    List<In> findByIdUser(Integer idUsers);
}
