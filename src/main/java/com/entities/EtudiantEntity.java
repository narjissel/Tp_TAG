package com.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etudiant", schema = "fpl2023", catalog = "")
public class EtudiantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = true, length = 45)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = 45)
    private String prenom;
    @Basic
    @Column(name = "cne", nullable = true, length = 45)
    private String cne;
    @ManyToOne
    @JoinColumn(name = "Filiere", referencedColumnName = "id")
    private FiliereEntity filiereByFiliere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtudiantEntity that = (EtudiantEntity) o;
        return id == that.id && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(cne, that.cne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, cne);
    }

    public FiliereEntity getFiliereByFiliere() {
        return filiereByFiliere;
    }

    public void setFiliereByFiliere(FiliereEntity filiereByFiliere) {
        this.filiereByFiliere = filiereByFiliere;
    }

    public Object getFiliere() {
        return filiereByFiliere;
    }
}
