package com.mahasiswa.dto;

import com.mahasiswa.models.entities.Fakultas;

public class JurusanData {
    private String nama;
    private Fakultas fakultas;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }
}
