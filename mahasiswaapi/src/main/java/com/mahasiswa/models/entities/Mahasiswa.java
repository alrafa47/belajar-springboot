package com.mahasiswa.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// inisialisasi
@Entity
// create tabel mahasiswa
@Table(name = "mahasiswas")
// mencegah infinite loop
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Mahasiswa implements Serializable {
    // set to primary
    @Id
    // set auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // configurasi properti field
    @Column(unique = true, length = 12, nullable = false)
    private String nim;

    @Column(nullable = false)
    private String nama;

    @ManyToOne
    private Jurusan jurusan;

    @ManyToMany
    @JoinTable(name = "matkul_mahasiswa", joinColumns = @JoinColumn(name = "mahasiswa_id"), inverseJoinColumns = @JoinColumn(name = "matkul_id"))
    @JsonManagedReference
    private Set<Matkul> matkuls;

    public void removeMatkul(Matkul matkul) {
        this.matkuls.remove(matkul);
        matkul.getMahasiswa().remove(this);
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public Set<Matkul> getMatkuls() {
        return matkuls;
    }

    public void setMatkuls(Set<Matkul> matkuls) {
        this.matkuls = matkuls;
    }

    public Mahasiswa(Long id, String nim, String nama) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
    }

    public Mahasiswa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
