package com.ismynr.KasinApp.service_impl;

import com.ismynr.KasinApp.entity.Out;
import com.ismynr.KasinApp.repository.OutRepo;
import com.ismynr.KasinApp.service.OutServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("OutServ")
public class OutServImpl implements OutServ {
    @Qualifier("OutRepo")
    @Autowired
    private OutRepo outrepo;

    @Override
    public List<Out> getAllOut() {
        return outrepo.findAll();
    }

    @Override
    public List<Out> getAllOutByIdUser(Integer idUsers) {
        return outrepo.findByIdUser(idUsers);
    }

    @Override
    public Out getOutById(String kode) {
        return outrepo.getOne(kode);
    }

    @Override
    public Out addOut(Out dataIn){
        return outrepo.save(dataIn);
    }

    @Override
    public void deleteOut(String kode){
        outrepo.deleteById(kode);
    }

    @Override
    public Out updateOut(String kode, Out dataOut){
        outrepo.getOne(kode);
        return outrepo.save(dataOut);
    }
}
