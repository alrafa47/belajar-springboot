package com.mahasiswa.controllers;

import com.mahasiswa.dto.MahasiswaData;
import com.mahasiswa.dto.MatkulData;
import com.mahasiswa.models.entities.Mahasiswa;
import com.mahasiswa.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// untuk mapping url/endpoint
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    // panggil service
    @Autowired
    private MahasiswaService mahasiswaService;

    // handle request get
    // @GetMapping
    // public name() {

    // }

    @PostMapping
    public Mahasiswa createMahasiswa(@RequestBody MahasiswaData mahasiswaData) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama(mahasiswa.getNama());
        mahasiswa.setNim(mahasiswa.getNim());
        // mahasiswa.setJurusan(mahasiswa.getJurusan());
        return mahasiswaService.saveMahasiswa(mahasiswa);
    }

    @GetMapping
    public Iterable<Mahasiswa> getAllData() {
        return mahasiswaService.allMahasiswa();
    }

    @DeleteMapping("/{id}")
    public void deleteMahasiswa(@PathVariable("id") Long id) {
        mahasiswaService.deleteMahasiswa(id);
    }

    @GetMapping("/{id}")
    public Mahasiswa getMahasiswaById(@PathVariable("id") Long id) {
        return mahasiswaService.findMahasiswa(id);
    }

    @PutMapping
    public Mahasiswa updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.saveMahasiswa(mahasiswa);
    }

    @PostMapping("/{id}/matkul")

    public void addMatkulMahasiswa(@RequestBody MatkulData matkulData, @PathVariable("id") Long id) {
        mahasiswaService.addMatkulMahasiswa(id, matkulData.getId());
    }

    @DeleteMapping("/{id}/matkul")
    public void deleteMatkulMahasiswa(@RequestBody MatkulData matkulData, @PathVariable("id") Long id) {
        mahasiswaService.deleteMatkulMahasiswa(id, matkulData.getId());
    }
}