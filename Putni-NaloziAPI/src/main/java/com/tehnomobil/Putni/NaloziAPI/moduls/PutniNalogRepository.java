package com.tehnomobil.Putni.NaloziAPI.moduls;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PutniNalogRepository extends CrudRepository<PutniNalog,Integer> {

    List<PutniNalog> findByKorisnikID(int userId);
    List<PutniNalog> findByAuto(String auto);

}
