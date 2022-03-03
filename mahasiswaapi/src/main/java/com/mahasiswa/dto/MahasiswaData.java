package com.mahasiswa.dto;

public class MahasiswaData {
    private String nim;
    private String nama;
    private Long jurusan;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getJurusan() {
        return jurusan;
    }

    public void setJurusan(Long jurusan) {
        this.jurusan = jurusan;
    }
}
