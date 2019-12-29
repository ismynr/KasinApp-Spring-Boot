package com.ismynr.KasinApp.service;

import com.ismynr.KasinApp.entity.Out;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OutServ {
    public List<Out> getAllOut();
    public List<Out> getAllOutByIdUser(Integer idUser);
    public Out getOutById(String kode);
    public Out addOut(Out dataOut);
    public void deleteOut (String kode);
    public Out updateOut(String kode, Out in);
}
