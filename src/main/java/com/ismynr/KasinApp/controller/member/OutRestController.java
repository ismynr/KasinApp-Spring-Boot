package com.ismynr.KasinApp.controller.member;

import com.ismynr.KasinApp.entity.Out;
import com.ismynr.KasinApp.service.OutServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member/api/kas_keluar")
public class OutRestController {
    @Qualifier("OutServ")
    @Autowired
    private OutServ outserv;

    @GetMapping(path="/")
    public List<Out> getAllOut(){
        return outserv.getAllOut();
    }

    @GetMapping(path = "/iu/{iduser}")
    public List<Out> getAllOutByIdUser(@PathVariable("iduser")Integer idUser) {
        return outserv.getAllOutByIdUser(idUser);
    }

    //    ADD DATA
    @PostMapping(value = "/")
    public Out restAddIn(@Validated @RequestBody Out out){
        return outserv.addOut(out);
    }

    //    GET DATA BY KODE PENGELUARAN
    @GetMapping(value = "/{kode}")
    public Out getOutById(@PathVariable("kode") String kode){
        return outserv.getOutById(kode);
    }

    //    DELETE DATA PEMASUKAN BY KODE
    @DeleteMapping(value = "/{kode}")
    public String deleteOut(@PathVariable(value = "kode") String kode) {
        String result = "";
        Out getOutById = outserv.getOutById(kode);

        if (getOutById == null) {
            result = "Kode Not Found";
            return result;
        }result = "OK";

        //Execute function
        outserv.deleteOut(kode);
        return result;
    }

    //    UPDATE DATA PEMASUKAN BY KODE
    @PutMapping(value = "/{kode}")
    public ResponseEntity<Out> restUpdateIn(@PathVariable(value = "kode") String kode, @Validated @RequestBody Out dataOut){
        Out in = outserv.getOutById(kode);

        if(in == null){
            return ResponseEntity.notFound().build();
        }

        //Set data modified
        in.setKeteranganOut(dataOut.getKeteranganOut());
        in.setJumlahOut(dataOut.getJumlahOut());
//        in.setTanggalIn(dataIn.getTanggalIn());

        return ResponseEntity.ok(outserv.updateOut(kode, in));
    }
}
