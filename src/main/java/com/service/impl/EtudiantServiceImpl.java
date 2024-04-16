package com.service.impl;

import com.dao.EtudiantDAO;
import com.entities.EtudiantEntity;
import com.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDAO etudiantDAO ;
    @Override
    @Transactional
    public void saveOrUpdate(EtudiantEntity e) {
        this.etudiantDAO.saveOrUpdate(e);
    }

    @Override
    @Transactional
    public void delete(EtudiantEntity e) {
      this.etudiantDAO.delete(e);
    }

    @Override
    public EtudiantEntity getById(int id) {
        return this.etudiantDAO.getById(id);
    }

    @Transactional
    @Override
    public List<EtudiantEntity> getAll() {
        List<EtudiantEntity> etudiants = this.etudiantDAO.getAll();
        return etudiants;

    }
}
