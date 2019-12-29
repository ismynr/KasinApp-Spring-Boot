package com.ismynr.KasinApp.service;

import com.ismynr.KasinApp.entity.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InServ {
    public List<In> getAllIn();
    public List<In> getAllInByIdUser(Integer idUsers);
    public In getInById(String kode);
    public void deleteIn (String kode);
    public In addIn (In dataIn);
    public In updateIn(String kode, In in);
}
