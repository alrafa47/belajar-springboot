package com.mahasiswa.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.mahasiswa.models.entities.Matkul;
import com.mahasiswa.models.repo.MatkulRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MatkulService {
    @Autowired
    private MatkulRepo matkulRepo;

    public Iterable<Matkul> getAllMatkul() {
        return matkulRepo.findAll();
    }

    public Matkul findByIdMatkul(Long id) {
        Optional<Matkul> matkul = matkulRepo.findById(id);
        if (!matkul.isPresent()) {
            return null;
        }
        return matkulRepo.findById(id).get();
    }

    public void deleteByIdMatkul(Long id) {
        matkulRepo.deleteById(id);
    }

    public Matkul saveMatkul(Matkul matkul) {
        return matkulRepo.save(matkul);
    }

}
