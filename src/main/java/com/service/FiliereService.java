package com.service;

import com.entities.FiliereEntity;

import java.util.List;

public interface FiliereService {
	void saveOrUpdate(FiliereEntity f);

	void delete(FiliereEntity f);

	FiliereEntity getById(int id);

	List<FiliereEntity> getAll();
}


