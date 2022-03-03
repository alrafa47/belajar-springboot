package com.mahasiswa.models.repo;

import com.mahasiswa.models.entities.Mahasiswa;

import org.springframework.data.repository.CrudRepository;

// DAO / Model
public interface MahasiswaRepo extends CrudRepository<Mahasiswa, Long> {

}
