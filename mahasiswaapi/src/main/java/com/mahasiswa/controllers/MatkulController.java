package com.mahasiswa.controllers;

import com.mahasiswa.models.entities.Matkul;
import com.mahasiswa.services.MatkulService;

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
@RequestMapping("api/matkul")
public class MatkulController {
    @Autowired
    private MatkulService matkulService;

    @GetMapping
    public Iterable<Matkul> getAllData() {
        return matkulService.getAllMatkul();
    }

    @GetMapping("/{id}")
    public Matkul findMatkul(@PathVariable("id") Long id) {
        return matkulService.findByIdMatkul(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMatkul(@PathVariable("id") Long id) {
        matkulService.deleteByIdMatkul(id);
    }

    @PostMapping()
    public Matkul storeMatkul(@RequestBody Matkul matkul) {
        return matkulService.saveMatkul(matkul);
    }

    @PutMapping
    public Matkul updateMatkul(@RequestBody Matkul matkul) {
        return matkulService.saveMatkul(matkul);
    }
}
