package com.example.senefoot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.senefoot.R;
import com.example.senefoot.model.Equipe;
import com.example.senefoot.model.Rencontre;

import java.util.List;

import static com.example.senefoot.rest.ApiClient.BASE_URL;

public class RencontreAdapter extends RecyclerView.Adapter<RencontreAdapter.ViewHolder> {
    private List<Rencontre> rencontreList;
    private LayoutInflater layoutInflater;
    private Context context;
    private int lastPosition = -1;

    public RencontreAdapter(List<Rencontre> rencontreList){
        this.rencontreList = rencontreList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating a new view
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipe,parent,false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rencontre, parent, false);
        //set the view's size, margins, paddings and layout parameters

        RencontreAdapter.ViewHolder vh = new RencontreAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        holder.txt_home_score.setText(rencontreList.get(position).getScoreEquipeDomicile());
        holder.txt_away_score.setText(rencontreList.get(position).getScoreEquipeExterieur());
        holder.txt_home_team.setText(rencontreList.get(position).getNomEquipeDomicile());
        holder.txt_away_team.setText(rencontreList.get(position).getNomEquipeExterieur());

        lastPosition = position;

    }

    @Override
    public int getItemCount() {
        return rencontreList == null ? (0) : rencontreList.size();

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView txt_home_score, txt_away_score, txt_home_team, txt_away_team;

        public ViewHolder(View v) {
            super(v);
            txt_home_score = (TextView)v.findViewById(R.id.txt_home_score);
            txt_away_score = (TextView)v.findViewById(R.id.txt_away_score);
            txt_home_team = (TextView)v.findViewById(R.id.txt_home_team);
            txt_away_team = (TextView)v.findViewById(R.id.txt_away_team);
        }
    }
}
