package com.ismynr.KasinApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pengeluaran")
public class Out {
    @Id
    @Column(name="kode_out")
    private String kodeOut;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "keterangan_out")
    private String keteranganOut;

    @Column(name = "jumlah_out")
    private Integer jumlahOut;

    @Column(name = "tanggal_out")
    private String tanggalOut;

    public Out() {
        super();
    }

    public Out(String kodeOut, String keteranganOut, Integer jumlahOut, String tanggalOut) {
        super();
        this.kodeOut = kodeOut;
        this.keteranganOut = keteranganOut;
        this.jumlahOut = jumlahOut;
        this.tanggalOut = tanggalOut;
    }

    public String getKodeOut() {
        return kodeOut;
    }

    public void setKodeOut(String kodeOut) {
        this.kodeOut = kodeOut;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getKeteranganOut() {
        return keteranganOut;
    }

    public void setKeteranganOut(String keteranganOut) {
        this.keteranganOut = keteranganOut;
    }

    public Integer getJumlahOut() {
        return jumlahOut;
    }

    public void setJumlahOut(Integer jumlahOut) {
        this.jumlahOut = jumlahOut;
    }

    public String getTanggalOut() {
        return tanggalOut;
    }

    public void setTanggalOut(String tanggalOut) {
        this.tanggalOut = tanggalOut;
    }
}
