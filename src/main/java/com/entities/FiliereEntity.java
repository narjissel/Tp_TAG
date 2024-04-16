package com.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "filiere", schema = "fpl2023", catalog = "")
public class FiliereEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @Basic
    @Column(name = "libelle", nullable = true, length = 45)
    private String libelle;
    @OneToMany(mappedBy = "filiereByFiliere")
    private Collection<EtudiantEntity> etudiantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiliereEntity that = (FiliereEntity) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, libelle);
    }

    public Collection<EtudiantEntity> getEtudiantsById() {
        return etudiantsById;
    }

    public void setEtudiantsById(Collection<EtudiantEntity> etudiantsById) {
        this.etudiantsById = etudiantsById;
    }
}
