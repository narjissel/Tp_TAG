package com.dao.impl;

import com.dao.EtudiantDAO;
import com.entities.EtudiantEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EtudiantDaoImpl extends HibernateDaoSupport implements EtudiantDAO {
    @Autowired
    public void setUpSessionFactory(SessionFactory sf) {
        this.setSessionFactory(sf);
    }


    @Transactional
    @Override
    public void saveOrUpdate(EtudiantEntity f) {
        this.getHibernateTemplate().saveOrUpdate(f);
    }

    @Transactional
    @Override
    public void delete(EtudiantEntity f) {
        this.getHibernateTemplate().delete(f);
    }

    @Override
    public EtudiantEntity getById(int id) {
        return this.getHibernateTemplate().get(EtudiantEntity.class, id);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<EtudiantEntity> getAll() {
        return (List<EtudiantEntity>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(EtudiantEntity.class));
    }


}
