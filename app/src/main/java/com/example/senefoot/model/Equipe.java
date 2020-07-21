
package com.example.senefoot.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipe {

    @SerializedName("idEquipe")
    @Expose
    private String idEquipe;
    @SerializedName("nomEquipe")
    @Expose
    private String nomEquipe;
    @SerializedName("imageEquipe")
    @Expose
    private String imageEquipe;

    /**
     * No args constructor for use in serialization
     *
     */
    public Equipe() {
    }

    /**
     *
     * @param idEquipe
     * @param imageEquipe
     * @param nomEquipe
     */
    public Equipe(String idEquipe, String nomEquipe, String imageEquipe) {
        super();
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.imageEquipe = imageEquipe;
    }

    public String getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(String idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getImageEquipe() {
        return imageEquipe;
    }

    public void setImageEquipe(String imageEquipe) {
        this.imageEquipe = imageEquipe;
    }

}