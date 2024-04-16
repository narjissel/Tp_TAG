package com.beans;

import com.entities.EtudiantEntity;
import com.entities.FiliereEntity;
import com.service.EtudiantService;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")

public class EtudiantBean {

    @Autowired
    private EtudiantService etudiantService;
    private EtudiantEntity etudiant;

    @Autowired
    private FiliereService filiereService;
    private boolean modifyContext;

    public EtudiantBean() {
        this.etudiant = new EtudiantEntity();

        this.modifyContext = false;
    }

    public EtudiantEntity getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantEntity etudiant) {
        this.etudiant = etudiant;
    }


    public boolean isModifyContext() {
        return modifyContext;
    }

    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }

    public List<EtudiantEntity> getEtudiants() {

        return this.etudiantService.getAll();
    }

    public String getLabel() {
        return isModifyContext() ? "Modification" : "Ajout";
    }

    @Transactional
    public void save() {

        this.etudiant.setFiliereByFiliere(filiereService.getById(this.filiere));
        this.etudiantService.saveOrUpdate(this.etudiant);
        this.etudiant = new EtudiantEntity();
        this.setModifyContext(false);
    }
    @Transactional
    public void modify(EtudiantEntity e) {

        this.etudiant = e;
        this.setModifyContext(true);
    }

    @Transactional
    public void delete(EtudiantEntity e) {

        this.etudiantService.delete(e);
        this.etudiant = new EtudiantEntity();
    }
     private int filiere;
     public  int getFiliere(){
        return filiere;
     }
     public void setFiliere(int filiere){
         this.filiere =filiere ;
     }

    //ajout de spring
  /*  public Object getFiliereOptions() {
        return  this.etudiant.getFiliere();
    }

   */
}
