package com.ismynr.KasinApp.entity;

import javax.persistence.*;

@Entity
@Table(name="pemasukan")
public class In {
    @Id
    @Column(name="kode_in")
    private String kodeIn;

    @Column(name="id_user")
    private int idUser;

    @Column(name="keterangan_in")
    private String keteranganIn;

    @Column(name="jumlah_in")
    private int jumlahIn;

    @Column(name="tanggal_in")
    private String tanggalIn;

    public In(){
        super();
    }

    public In(String kodeIn, String keteranganIn, Integer jumlahIn, String tanggalIn){
        super();
        this.kodeIn = kodeIn;
        this.keteranganIn = keteranganIn;
        this.jumlahIn = jumlahIn;
        this.tanggalIn = tanggalIn;
    }

    public String getKodeIn() {
        return kodeIn;
    }

    public void setKodeIn(String kodeIn) {
        this.kodeIn = kodeIn;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getKeteranganIn() {
        return keteranganIn;
    }

    public void setKeteranganIn(String keteranganIn) {
        this.keteranganIn = keteranganIn;
    }

    public int getJumlahIn() {
        return jumlahIn;
    }

    public void setJumlahIn(int jumlahIn) {
        this.jumlahIn = jumlahIn;
    }

    public String getTanggalIn() {
        return tanggalIn;
    }

    public void setTanggalIn(String tanggalIn) {
        this.tanggalIn = tanggalIn;
    }
}
