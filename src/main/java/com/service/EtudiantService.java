package com.service;

import com.entities.EtudiantEntity;

import java.util.List;

public interface EtudiantService {
    void saveOrUpdate(EtudiantEntity e);

    void delete(EtudiantEntity e);

    EtudiantEntity getById(int id);

    List<EtudiantEntity> getAll();
}
