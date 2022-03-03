package com.mahasiswa.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "matkul")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Matkul implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nama;

    @ManyToOne
    @JsonBackReference
    private Jurusan jurusan;

    @Column(nullable = false)
    private Integer sks;

    @ManyToMany(mappedBy = "matkuls")
    @JsonBackReference
    // @JoinTable(name = "matkul_mahasiswa", joinColumns = @JoinColumn(name =
    // "matkul_id"), inverseJoinColumns = @JoinColumn(name = "mahasiswa_id"))
    private Set<Mahasiswa> mahasiswas;

    public void removeMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswas.remove(mahasiswa);
        mahasiswa.getMatkuls().remove(this);
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public Set<Mahasiswa> getMahasiswa() {
        return mahasiswas;
    }

    public void setMahasiswa(Set<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Matkul(Long id, String nama, Integer sks) {
        this.id = id;
        this.nama = nama;
        this.sks = sks;
    }

    public Matkul() {
    }
}
