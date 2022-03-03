package com.mahasiswa.controllers;

import com.mahasiswa.dto.JurusanData;
import com.mahasiswa.models.entities.Jurusan;
import com.mahasiswa.services.JurusanService;

import org.modelmapper.ModelMapper;
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
@RequestMapping("api/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService jurusanService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Jurusan> getAllData() {
        return jurusanService.getAllJurusan();
    }

    @GetMapping("/{id}")
    public Jurusan findJurusan(@PathVariable("id") Long id) {
        return jurusanService.findByIdJurusan(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJurusan(@PathVariable("id") Long id) {
        jurusanService.deleteByIdJurusan(id);
    }

    @PostMapping()
    public Jurusan storeJurusan(@RequestBody JurusanData jurusandData) {
        Jurusan jurusan = modelMapper.map(jurusandData, Jurusan.class);
        return jurusanService.saveJurusan(jurusan);
    }

    @PutMapping
    public Jurusan updateJurusan(@RequestBody Jurusan jurusan) {
        return jurusanService.saveJurusan(jurusan);
    }
}
