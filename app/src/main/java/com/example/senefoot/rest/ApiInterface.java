package com.example.senefoot.rest;

import com.example.senefoot.model.Equipe;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    // @SerializedName("equipes")
    @GET("equipe.php")
    Call<List<Equipe>> listeEquipes(@Query("nomCategorie") String nomCategorie );

}
