package com.service.impl;

import com.dao.FiliereDAO;
import com.entities.FiliereEntity;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
*  cette classe FiliereServiceImpl agit comme une couche intermédiaire entre le contrôleur
* (ou la couche d'interface utilisateur) et la couche d'accès aux données (FiliereDAO).
* Elle utilise les méthodes définies dans FiliereDAO pour effectuer des opérations CRUD sur
* les entités Filiere, tout en bénéficiant de la gestion des transactions fournie par Spring
* via les annotations @Transactional.
* */

@Component
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	private FiliereDAO filiereDao ;

	@Override
	@Transactional
	public void saveOrUpdate(FiliereEntity f) {
		this.filiereDao.saveOrUpdate(f);
	}

	@Override
	@Transactional
	public void delete(FiliereEntity f) {
		this.filiereDao.delete(f);		
	}

	@Override
	public FiliereEntity getById(int id) {
		return this.filiereDao.getById(id);
	}

	@Override
	@Transactional
	public List<FiliereEntity> getAll() {
		List<FiliereEntity> filieres = this.filiereDao.getAll();
		System.out.println("test ===> "+ filieres.get(0).getEtudiantsById().size());
		return filieres;
	}
}
