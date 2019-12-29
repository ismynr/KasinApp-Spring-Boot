package com.ismynr.KasinApp.service_impl;

import com.ismynr.KasinApp.entity.In;
import com.ismynr.KasinApp.repository.InRepo;
import com.ismynr.KasinApp.service.InServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("InServ")
public class InServImpl implements InServ {
    @Qualifier("InRepo")
    @Autowired
    private InRepo inrepo;

    @Override
    public List<In> getAllIn() {
        return inrepo.findAll();
    }

    @Override
    public List<In> getAllInByIdUser(Integer idUsers) {
        return inrepo.findByIdUser(idUsers);
    }

    @Override
    public In getInById(String kode) {
        return inrepo.getOne(kode);
    }

    @Override
    public void deleteIn(String kode) {
        inrepo.deleteById(kode);
    }

    @Override
    public In addIn(In dataIn){
        return inrepo.save(dataIn);
    }

    @Override
    public In updateIn(String kode, In dataIn){
        inrepo.getOne(kode);
        return inrepo.save(dataIn);
    }

}
