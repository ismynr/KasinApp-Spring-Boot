package com.ismynr.KasinApp.controller.member;

import com.ismynr.KasinApp.entity.In;
import com.ismynr.KasinApp.entity.Out;
import com.ismynr.KasinApp.service.InServ;
import com.ismynr.KasinApp.service.OutServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member/api/kas_masuk")
public class InRestController {

    @Qualifier("InServ")
    @Autowired
    private InServ inserv;

//    GET ALL DATA PEMASUKAN
    @GetMapping(path = "/")
    public List<In> getAllIn() {
        return inserv.getAllIn();
    }

    @GetMapping(path = "/iu/{iduser}")
    public List<In> getAllInByIdUser(@PathVariable("iduser")Integer idUser) {
        return inserv.getAllInByIdUser(idUser);
    }

    //    ADD DATA
    @PostMapping(value = "/")
    public In restAddOut(@Validated @RequestBody In in){
        return inserv.addIn(in);
    }

//    GET DATA BY KODE PEMASUKAN
    @GetMapping(value = "/{kode}")
    public In getInById(@PathVariable("kode") String kode) {
        return inserv.getInById(kode);
    }

//    DELETE DATA PEMASUKAN BY KODE
    @DeleteMapping(value = "/{kode}")
    public String deleteIn(@PathVariable(value = "kode") String kode) {
        String result = "";
        In getInById = inserv.getInById(kode);

        if (getInById == null) {
            result = "Kode Not Found";
            return result;
        }result = "OK";

        //Execute function
        inserv.deleteIn(kode);
        return result;
    }

//    UPDATE DATA PEMASUKAN BY KODE
    @PutMapping(value = "/{kode}")
    public ResponseEntity<In> restUpdateIn(@PathVariable(value = "kode") String kode, @Validated @RequestBody In dataIn){
        In in = inserv.getInById(kode);

        if(in == null){
            return ResponseEntity.notFound().build();
        }

        //Set data modified
        in.setKeteranganIn(dataIn.getKeteranganIn());
        in.setJumlahIn(dataIn.getJumlahIn());
//        in.setTanggalIn(dataIn.getTanggalIn());

        return ResponseEntity.ok(inserv.updateIn(kode, in));
    }
}