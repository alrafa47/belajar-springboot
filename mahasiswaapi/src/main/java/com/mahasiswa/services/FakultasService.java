package com.mahasiswa.services;

import javax.transaction.Transactional;

import com.mahasiswa.models.entities.Fakultas;
import com.mahasiswa.models.repo.FakultasRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FakultasService {

    @Autowired
    private FakultasRepo fakultasRepo;

    public Iterable<Fakultas> getAllFakultas() {
        return fakultasRepo.findAll();
    }

    public Fakultas findByIdFakultas(Long id) {
        return fakultasRepo.findById(id).get();
    }

    public void deleteByIdFakultas(Long id) {
        fakultasRepo.deleteById(id);
    }

    public Fakultas saveFakultas(Fakultas fakultas) {
        return fakultasRepo.save(fakultas);
    }

}
