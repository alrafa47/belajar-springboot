package com.mahasiswa.services;

import javax.transaction.Transactional;

import com.mahasiswa.models.entities.Jurusan;
import com.mahasiswa.models.repo.JurusanRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JurusanService {
    @Autowired
    private JurusanRepo jurusanRepo;

    public Iterable<Jurusan> getAllJurusan() {
        return jurusanRepo.findAll();
    }

    public Jurusan findByIdJurusan(Long id) {
        return jurusanRepo.findById(id).get();
    }

    public void deleteByIdJurusan(Long id) {
        jurusanRepo.deleteById(id);
    }

    public Jurusan saveJurusan(Jurusan jurusan) {
        return jurusanRepo.save(jurusan);
    }

}
