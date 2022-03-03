package com.mahasiswa.controllers;

import com.mahasiswa.dto.FakultasData;
import com.mahasiswa.models.entities.Fakultas;
import com.mahasiswa.services.FakultasService;

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
@RequestMapping("api/fakultas")
public class FakultasController {

    @Autowired
    private FakultasService fakultasService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Fakultas> getAllData() {
        return fakultasService.getAllFakultas();
    }

    @GetMapping("/{id}")
    public Fakultas findFakultas(@PathVariable("id") Long id) {
        return fakultasService.findByIdFakultas(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFakultas(@PathVariable("id") Long id) {
        fakultasService.deleteByIdFakultas(id);
    }

    @PostMapping
    public Fakultas storeFakultas(@RequestBody FakultasData fakultasData) {
        Fakultas fakultas = modelMapper.map(fakultasData, Fakultas.class);
        return fakultasService.saveFakultas(fakultas);
    }

    @PutMapping
    public Fakultas updateFakultas(@RequestBody FakultasData fakultasData) {
        Fakultas fakultas = modelMapper.map(fakultasData, Fakultas.class);
        return fakultasService.saveFakultas(fakultas);
    }
}
