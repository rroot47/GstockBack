package com.stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_f;
    private  String code_f;
    private  String libelle_f;
    private  String contact_f;
    private  String adresse_f;
    private  String email_f;
    private  String tel_f;
    private  String matfis_f;
    private  String asuj_f;
    private String login_f;
    private String pwd_f;
    private  float soldeinit_f;
    private  float solde_f;

    public Fournisseur() {
    }

    public Fournisseur(String code_f, String libelle_f, String contact_f, String adresse_f, String email_f,
                   String tel_f, String matfis_f, String asuj_f,String login_f, String pwd_f, float soldeinit_f, float solde_f) {

        this.code_f=code_f;
        this.libelle_f=libelle_f;
        this.contact_f=contact_f;
        this.adresse_f=adresse_f;
        this.email_f=email_f;
        this.tel_f=tel_f;
        this.matfis_f=matfis_f;
        this.asuj_f=asuj_f;
        this.login_f=login_f;
        this.pwd_f=pwd_f;
        this.soldeinit_f=soldeinit_f;
        this.solde_f=solde_f;
    }

    public Long getId_f() {
        return id_f;
    }

    public void setId_f(Long id_f) {
        this.id_f = id_f;
    }

    public String getCode_f() {
        return code_f;
    }

    public void setCode_f(String code_f) {
        this.code_f = code_f;
    }

    public String getLibelle_f() {
        return libelle_f;
    }

    public void setLibelle_f(String libelle_f) {
        this.libelle_f = libelle_f;
    }

    public String getContact_f() {
        return contact_f;
    }

    public void setContact_f(String contact_f) {
        this.contact_f = contact_f;
    }

    public String getAdresse_f() {
        return adresse_f;
    }

    public void setAdresse_f(String adresse_f) {
        this.adresse_f = adresse_f;
    }

    public String getEmail_f() {
        return email_f;
    }

    public void setEmail_f(String email_f) {
        this.email_f = email_f;
    }

    public String getTel_f() {
        return tel_f;
    }

    public void setTel_f(String tel_f) {
        this.tel_f = tel_f;
    }

    public String getMatfis_f() {
        return matfis_f;
    }

    public void setMatfis_f(String matfis_f) {
        this.matfis_f = matfis_f;
    }

    public String getAsuj_f() {
        return asuj_f;
    }

    public void setAsuj_f(String asuj_f) {
        this.asuj_f = asuj_f;
    }

    public String getLogin_f() {
        return login_f;
    }

    public void setLogin_f(String lonin_f) {
        this.login_f = login_f;
    }

    public String getPwd_f() {
        return pwd_f;
    }

    public void setPwd_f(String pwd_f) {
        this.pwd_f = pwd_f;
    }

    public float getSoldeinit_f() {
        return soldeinit_f;
    }

    public void setSoldeinit_f(float soldeinit_f) {
        this.soldeinit_f = soldeinit_f;
    }

    public float getSolde_f() {
        return solde_f;
    }

    public void setSolde_f(float solde_f) {
        this.solde_f = solde_f;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id_f=" + id_f +
                ", code_f='" + code_f + '\'' +
                ", libelle_f='" + libelle_f + '\'' +
                ", contact_f='" + contact_f + '\'' +
                ", adresse_f='" + adresse_f + '\'' +
                ", email_f='" + email_f + '\'' +
                ", tel_f='" + tel_f + '\'' +
                ", matfis_f='" + matfis_f + '\'' +
                ", asuj_f='" + asuj_f + '\'' +
                ", soldeinit_f=" + soldeinit_f +
                ", solde_f=" + solde_f +
                '}';
    }
}
