package com.stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_cat;
    private  String code_cat;
    private  String libelle_cat;

    public Categories(String code_cat, String libelle_cat){
        this.code_cat=code_cat;
        this.libelle_cat=libelle_cat;
    }

    public Categories(){}

    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
    }

    public String getCode_cat() {
        return code_cat;
    }

    public void setCode_cat(String code_cat) {
        this.code_cat = code_cat;
    }

    public String getLibelle_cat() {
        return libelle_cat;
    }

    public void setLibelle_cat(String libelle_cat) {
        this.libelle_cat = libelle_cat;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id_cat=" + id_cat +
                ", code_cat='" + code_cat + '\'' +
                ", libelle_cat='" + libelle_cat + '\'' +
                '}';
    }
}
