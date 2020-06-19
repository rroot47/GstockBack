package com.stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_art;
    private  String code_art;
    private  String libelle_art;
    private float prixachat_art;
    private int tva_art;
    private int fodec_art;
    private int dc;
    private float prixvente_art;
    private float stockinit_art;
    private float stock_art;
    private String img_art;
    private long id_cat;
    private long id_scat;

    public Articles(String code_art, String libelle_art, float prixachat_art, int tva_art, int fodec_art, int dc,
                    float prixvente_art, float stockinit_art, float stock_art, String img_art, long id_cat, long id_scat) {
        this.code_art = code_art;
        this.libelle_art = libelle_art;
        this.prixachat_art = prixachat_art;
        this.tva_art = tva_art;
        this.fodec_art = fodec_art;
        this.dc=dc;
        this.prixvente_art = prixvente_art;
        this.stockinit_art = stockinit_art;
        this.stock_art = stock_art;
        this.img_art=img_art;
        this.id_cat=id_cat;
        this.id_scat=id_scat;
    }

    public Articles() {
    }

    public Long getId_art() {
        return id_art;
    }

    public void setId_art(Long id_art) {
        this.id_art = id_art;
    }

    public String getCode_art() {
        return code_art;
    }

    public void setCode_art(String code_art) {
        this.code_art = code_art;
    }

    public String getLibelle_art() {
        return libelle_art;
    }

    public void setLibelle_art(String libelle_art) {
        this.libelle_art = libelle_art;
    }

    public float getPrixachat_art() {
        return prixachat_art;
    }

    public void setPrixachat_art(float prixachat_art) {
        this.prixachat_art = prixachat_art;
    }

    public int getTva_art() {
        return tva_art;
    }

    public void setTva_art(int tva_art) {
        this.tva_art = tva_art;
    }

    public int getFodec_art() {
        return fodec_art;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public void setFodec_art(int fodec_art) {
        this.fodec_art = fodec_art;
    }

    public float getPrixvente_art() {
        return prixvente_art;
    }

    public void setPrixvente_art(float prixvente_art) {
        this.prixvente_art = prixvente_art;
    }

    public float getStockinit_art() {
        return stockinit_art;
    }

    public void setStockinit_art(float stockinit_art) {
        this.stockinit_art = stockinit_art;
    }

    public float getStock_art() {
        return stock_art;
    }

    public void setStock_art(float stock_art) {
        this.stock_art = stock_art;
    }

    public String getImg_art() {
        return img_art;
    }

    public void setImg_art(String img_art) {
        this.img_art = img_art;
    }

    public long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public long getId_scat() {
        return id_scat;
    }

    public void setId_scat(long id_scat) {
        this.id_scat = id_scat;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id_art=" + id_art +
                ", code_art='" + code_art + '\'' +
                ", libelle_art='" + libelle_art + '\'' +
                ", prixachat_art=" + prixachat_art +
                ", tva_art=" + tva_art +
                ", fodec_art=" + fodec_art +
                ", prixvente_art=" + prixvente_art +
                ", stockinit_art=" + stockinit_art +
                ", stock_art=" + stock_art +
                '}';
    }
}
