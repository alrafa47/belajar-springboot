package com.mahasiswa.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.mahasiswa.models.entities.Mahasiswa;
import com.mahasiswa.models.entities.Matkul;
import com.mahasiswa.models.repo.MahasiswaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// bussiness logic
@Service
@Transactional
public class MahasiswaService {

    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    @Autowired
    private MatkulService matkulService;

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaRepo.save(mahasiswa);
    }

    public Mahasiswa findMahasiswa(Long id) {
        Optional<Mahasiswa> mahasiswa = mahasiswaRepo.findById(id);
        if (!mahasiswa.isPresent()) {
            return null;
        }
        return mahasiswaRepo.findById(id).get();
    }

    public Iterable<Mahasiswa> allMahasiswa() {
        return mahasiswaRepo.findAll();
    }

    public void deleteMahasiswa(Long id) {
        mahasiswaRepo.deleteById(id);
    }

    public void addMatkulMahasiswa(Long idMahasiswa, Long matkulId) {

        Mahasiswa mahasiswa = findMahasiswa(idMahasiswa);
        if (mahasiswa == null) {
            throw new RuntimeException("mahasiswa With ID " + idMahasiswa + " not found");
        }
        Matkul matkul = matkulService.findByIdMatkul(matkulId);
        if (matkul == null) {
            throw new RuntimeException("Matkul With ID " + idMahasiswa + " not found");
        }

        if (mahasiswa.getJurusan().getId() == matkul.getJurusan().getId()) {
            throw new RuntimeException(
                    matkul.getNama() + " bukan untuk mahasiswa jurusan " +
                            mahasiswa.getJurusan().getNama());
        }
        mahasiswa.getMatkuls().add(matkul);
        saveMahasiswa(mahasiswa);
    }

    public void deleteMatkulMahasiswa(Long idMahasiswa, Long matkulId) {
        Mahasiswa mahasiswa = findMahasiswa(idMahasiswa);
        if (mahasiswa == null) {
            throw new RuntimeException("mahasiswa With ID " + idMahasiswa + " not found");
        }
        Matkul matkul = matkulService.findByIdMatkul(matkulId);
        if (matkul == null) {
            throw new RuntimeException("Matkul With ID " + idMahasiswa + " not found");
        }
        mahasiswa.removeMatkul(matkul);
        saveMahasiswa(mahasiswa);
    }

}
