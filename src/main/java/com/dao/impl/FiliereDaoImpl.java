package com.dao.impl;

import com.dao.FiliereDAO;
import com.entities.FiliereEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*  cette classe FiliereDaoImpl encapsule l'accès aux données pour l'entité FiliereEntity
en utilisant les fonctionnalités de la bibliothèque Hibernate. Elle utilise des méthodes fournies
par HibernateDaoSupport pour accéder à la session Hibernate et exécuter des opérations CRUD
(Create, Read, Update, Delete) sur les entités, tout en bénéficiant de la gestion des transactions
fournie par Spring via les annotations @Transactional.
*/
@Repository
//Cette classe étend HibernateDaoSupport, une classe fournie par Spring qui simplifie l'utilisation
// de Hibernate dans les classes DAO. Elle fournit des méthodes utilitaires pour accéder
// à la session Hibernate, comme getHibernateTemplate().
public class FiliereDaoImpl extends HibernateDaoSupport implements FiliereDAO {

	@Autowired
	// Utilisée pour injecter la session Hibernate (SessionFactory) dans cette classe.
	// La méthode setUpSessionFactory est annotée avec @Autowired pour configurer la session Hibernate pour cette classe.
	public void setUpSessionFactory(SessionFactory sf) {
		this.setSessionFactory(sf);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(FiliereEntity f) {
		this.getHibernateTemplate().saveOrUpdate(f);
	}
	@Override
	@Transactional
	public void delete(FiliereEntity f) {
		this.getHibernateTemplate().delete(f);
	}

	@Override
	public FiliereEntity getById(int id) {
		return this.getHibernateTemplate().get(FiliereEntity.class, id);
	}

	@SuppressWarnings("unchecked") // utilisée pour supprimer les avertissements du compilateur lorsqu'il y a des opérations non typées
	@Override
	public List<FiliereEntity> getAll() {
		return (List<FiliereEntity>) this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(FiliereEntity.class));
	}


}
