package com.mahasiswa.dto;

public class MatkulData {
    private Long id;
    private String nama;
    private Integer sks;

    public String getNama() {
        return nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }
}
