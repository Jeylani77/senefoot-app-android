package com.example.senefoot.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rencontre {

    @SerializedName("idRencontre")
    @Expose
    private String idRencontre;
    @SerializedName("lieu")
    @Expose
    private String lieu;
    @SerializedName("prixTicket")
    @Expose
    private String prixTicket;
    @SerializedName("nomEquipeDomicile")
    @Expose
    private String nomEquipeDomicile;
    @SerializedName("nomEquipeExterieur")
    @Expose
    private String nomEquipeExterieur;
    @SerializedName("scoreEquipeDomicile")
    @Expose
    private String scoreEquipeDomicile;
    @SerializedName("scoreEquipeExterieur")
    @Expose
    private String scoreEquipeExterieur;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rencontre() {
    }

    /**
     *
     * @param prixTicket
     * @param nomEquipeExterieur
     * @param nomEquipeDomicile
     * @param idRencontre
     * @param scoreEquipeDomicile
     * @param scoreEquipeExterieur
     * @param lieu
     */
    public Rencontre(String idRencontre, String lieu, String prixTicket, String nomEquipeDomicile, String nomEquipeExterieur, String scoreEquipeDomicile, String scoreEquipeExterieur) {
        super();
        this.idRencontre = idRencontre;
        this.lieu = lieu;
        this.prixTicket = prixTicket;
        this.nomEquipeDomicile = nomEquipeDomicile;
        this.nomEquipeExterieur = nomEquipeExterieur;
        this.scoreEquipeDomicile = scoreEquipeDomicile;
        this.scoreEquipeExterieur = scoreEquipeExterieur;
    }

    public String getIdRencontre() {
        return idRencontre;
    }

    public void setIdRencontre(String idRencontre) {
        this.idRencontre = idRencontre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPrixTicket() {
        return prixTicket;
    }

    public void setPrixTicket(String prixTicket) {
        this.prixTicket = prixTicket;
    }

    public String getNomEquipeDomicile() {
        return nomEquipeDomicile;
    }

    public void setNomEquipeDomicile(String nomEquipeDomicile) {
        this.nomEquipeDomicile = nomEquipeDomicile;
    }

    public String getNomEquipeExterieur() {
        return nomEquipeExterieur;
    }

    public void setNomEquipeExterieur(String nomEquipeExterieur) {
        this.nomEquipeExterieur = nomEquipeExterieur;
    }

    public String getScoreEquipeDomicile() {
        return scoreEquipeDomicile;
    }

    public void setScoreEquipeDomicile(String scoreEquipeDomicile) {
        this.scoreEquipeDomicile = scoreEquipeDomicile;
    }

    public String getScoreEquipeExterieur() {
        return scoreEquipeExterieur;
    }

    public void setScoreEquipeExterieur(String scoreEquipeExterieur) {
        this.scoreEquipeExterieur = scoreEquipeExterieur;
    }

}