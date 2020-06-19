package com.stock.entities;

import javax.persistence.*;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_client;
    private  String code_client;
    private  String libelle_client;
    private  String contact_client;
    private  String adresse_client;
    private  String email_client;
    private  String tel_client;
    private  String matfis_client;
    private String timbre_client;
    private  String asuj_client;
    private  float soldeinit_client;
    private  float solde_client;
    private  String login_client;
    private  String pwd_client;

    public Clients(String code_client, String libelle_client, String contact_client, String adresse_client, String email_client,
                   String tel_client, String matfis_client, String timbre_client, String asuj_client, float soldeinit_client, float solde_client, String login_client,String pwd_client) {

        this.code_client=code_client;
        this.libelle_client=libelle_client;
        this.contact_client=contact_client;
        this.adresse_client=adresse_client;
        this.email_client=email_client;
        this.tel_client=tel_client;
        this.matfis_client=matfis_client;
        this.timbre_client=timbre_client;
        this.asuj_client=asuj_client;
        this.soldeinit_client=soldeinit_client;
        this.solde_client=solde_client;
        this.login_client=login_client;
        this.pwd_client=pwd_client;
    }

    public Clients() {
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getCode_client() {
        return code_client;
    }

    public void setCode_client(String code_client) {
        this.code_client = code_client;
    }

    public String getLibelle_client() {
        return libelle_client;
    }

    public void setLibelle_client(String libelle_client) {
        this.libelle_client = libelle_client;
    }

    public String getContact_client() {
        return contact_client;
    }

    public void setContact_client(String contact_client) {
        this.contact_client = contact_client;
    }

    public String getAdresse_client() {
        return adresse_client;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresse_client = adresse_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getTel_client() {
        return tel_client;
    }

    public void setTel_client(String tel_client) {
        this.tel_client = tel_client;
    }

    public String getMatfis_client() {
        return matfis_client;
    }

    public void setMatfis_client(String matfis_client) {
        this.matfis_client = matfis_client;
    }

    public String getTimbre_client() {
        return timbre_client;
    }

    public void setTimbre_client(String timbre_client) {
        this.timbre_client = timbre_client;
    }

    public String getAsuj_client() {
        return asuj_client;
    }

    public void setAsuj_client(String asuj_client) {
        this.asuj_client = asuj_client;
    }

    public float getSoldeinit_client() {
        return soldeinit_client;
    }

    public void setSoldeinit_client(float soldeinit_client) {
        this.soldeinit_client = soldeinit_client;
    }

    public float getSolde_client() {
        return solde_client;
    }

    public void setSolde_client(float solde_client) {
        this.solde_client = solde_client;
    }

    public String getLogin_client() {
        return login_client;
    }

    public void setLogin_client(String login_client) {
        this.login_client = login_client;
    }

    public String getPwd_client() {
        return pwd_client;
    }

    public void setPwd_client(String pwd_client) {
        this.pwd_client = pwd_client;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id_client=" + id_client +
                ", code_client='" + code_client + '\'' +
                ", libelle_client='" + libelle_client + '\'' +
                ", contact_client='" + contact_client + '\'' +
                ", adresse_client='" + adresse_client + '\'' +
                ", email_client='" + email_client + '\'' +
                ", tel_client='" + tel_client + '\'' +
                ", matfis_client='" + matfis_client + '\'' +
                ", asuj_client='" + asuj_client + '\'' +
                ", soldeinit_client=" + soldeinit_client +
                ", solde_client=" + solde_client +
                ", login_client='" + login_client + '\'' +
                ", pwd_client='" + pwd_client + '\'' +
                '}';
    }
}

