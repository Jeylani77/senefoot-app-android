package com.example.senefoot.rest;

import com.example.senefoot.model.Equipe;
import com.example.senefoot.model.Rencontre;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("equipe.php")
    Call<List<Equipe>> listeEquipes(@Query("nomCategorie") String nomCategorie );

    @GET("rencontre.php")
    Call<List<Rencontre>> listeRencontres(@Query("statut") String statut);

}
