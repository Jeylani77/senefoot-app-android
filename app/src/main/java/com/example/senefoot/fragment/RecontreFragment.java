package com.example.senefoot.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.senefoot.R;
import com.example.senefoot.adapter.EquipeAdapter;
import com.example.senefoot.adapter.RencontreAdapter;
import com.example.senefoot.model.Equipe;
import com.example.senefoot.model.Rencontre;
import com.example.senefoot.rest.ApiClient;
import com.example.senefoot.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecontreFragment extends Fragment {
    private ApiInterface apiService;
    public static List<Rencontre> rencontreList = new ArrayList<>();
    public static String met="";
    private RencontreAdapter rencontreAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar pb_rencontre;
    private RecyclerView.LayoutManager mLayoutManager;
    private String statut="";
    public RecontreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recontre, container, false);

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        pb_rencontre = (ProgressBar) view.findViewById(R.id.pb_rencontre);
        pb_rencontre.setVisibility(View.VISIBLE);
        Spinner mySpinner = (Spinner) view.findViewById(R.id.spin_league);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                statut = adapterView.getItemAtPosition(i).toString();
                loadData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rv_rencontre);

    }
    public void loadData() {
        pb_rencontre.setVisibility(View.VISIBLE);
        mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new GridLayoutManager(MetsActivity.this,2,GridLayoutManager.VERTICAL,false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(mLayoutManager);

        //it get the title of menu initialized before in MenuActivity
        // met=getIntent().getStringExtra("MET");

        //Integrate Retrofit
        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Rencontre>> call= apiService.listeRencontres(statut);
        /*Log the URL called*/
        Log.d("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Rencontre>>() {
            @Override
            public void onResponse(Call<List<Rencontre>> call, Response<List<Rencontre>> response) {
                Log.d("Tous les rencontres", response.body()+"");
                pb_rencontre.setVisibility(View.GONE);
                rencontreList = response.body();
                showRencontre();
            }

            @Override
            public void onFailure(Call<List<Rencontre>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }
    // this method manage the view of Equipes
    public void showRencontre() {
        rencontreAdapter =new RencontreAdapter(rencontreList);
        mRecyclerView.setAdapter(rencontreAdapter);
    }
}