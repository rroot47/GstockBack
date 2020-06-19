package com.stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_scat;
    private  String code_scat;
    private  String id_cat;
    private  String libelle_scat;

    public Scategorie() {
    }

    public Scategorie(String code_scat, String id_cat, String libelle_scat) {
        this.code_scat = code_scat;
        this.id_cat = id_cat;
        this.libelle_scat = libelle_scat;
    }

    public Long getId_scat() {
        return id_scat;
    }

    public void setId_scat(Long id_scat) {
        this.id_scat = id_scat;
    }

    public String getCode_scat() {
        return code_scat;
    }

    public void setCode_scat(String code_scat) {
        this.code_scat = code_scat;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }

    public String getLibelle_scat() {
        return libelle_scat;
    }

    public void setLibelle_scat(String libelle_scat) {
        this.libelle_scat = libelle_scat;
    }

    @Override
    public String toString() {
        return "Scategorie{" +
                "id_scat=" + id_scat +
                ", code_scat='" + code_scat + '\'' +
                ", id_cat='" + id_cat + '\'' +
                ", libelle_scat='" + libelle_scat + '\'' +
                '}';
    }
}
