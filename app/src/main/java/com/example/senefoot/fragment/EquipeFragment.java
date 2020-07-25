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
import android.widget.Toast;

import com.example.senefoot.MainActivity;
import com.example.senefoot.R;
import com.example.senefoot.adapter.EquipeAdapter;
import com.example.senefoot.model.Equipe;
import com.example.senefoot.rest.ApiClient;
import com.example.senefoot.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EquipeFragment extends Fragment {
    private ApiInterface apiService;
    public static List<Equipe> equipeList = new ArrayList<>();
    public static String met="";
    private EquipeAdapter equipeAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar pb_team;
    private RecyclerView.LayoutManager mLayoutManager;
    private String categorie="";

    public EquipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equipe, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rv_team);
        pb_team = (ProgressBar)view.findViewById(R.id.pb_team);
        pb_team.setVisibility(View.VISIBLE);

        Spinner mySpinner = (Spinner) view.findViewById(R.id.spin_league);
        categorie = mySpinner.getSelectedItem().toString();
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                categorie = adapterView.getItemAtPosition(i).toString();
                loadData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void loadData() {
        pb_team.setVisibility(View.VISIBLE);

        mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new GridLayoutManager(MetsActivity.this,2,GridLayoutManager.VERTICAL,false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(mLayoutManager);

        //it get the title of menu initialized before in MenuActivity
        // met=getIntent().getStringExtra("MET");

        //Integrate Retrofit
        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Equipe>> call= apiService.listeEquipes(categorie);


        /*Log the URL called*/
        Log.d("URL Called", call.request().url() + "");
        call.enqueue(new Callback<List<Equipe>>() {
            @Override
            public void onResponse(Call<List<Equipe>> call, Response<List<Equipe>> response) {
                Log.d("Tous les équipes", response.body()+"");
                pb_team.setVisibility(View.GONE);
                equipeList = response.body();
                showEquipe();

            }

            @Override
            public void onFailure(Call<List<Equipe>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }
    // this method manage the view of Equipes
    public void showEquipe() {
        equipeAdapter =new EquipeAdapter(equipeList);
        mRecyclerView.setAdapter(equipeAdapter);
        //notifyDataSetChanged();

    }
}