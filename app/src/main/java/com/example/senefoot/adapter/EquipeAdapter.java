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

import java.util.List;

import static com.example.senefoot.rest.ApiClient.BASE_URL;

public class EquipeAdapter extends RecyclerView.Adapter<EquipeAdapter.ViewHolder> {

    private List<Equipe> equipeList;
   // private List<Equipe> filteredMet;
    private LayoutInflater layoutInflater;
    private Context context;
    private int lastPosition = -1;
    // public static String image_url="";

    public EquipeAdapter(List<Equipe> equipeList){
        this.equipeList = equipeList;
        //this.filteredMet = metList;
    }

    @Override
    public EquipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creating a new view
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipe,parent,false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipe, parent, false);
        //set the view's size, margins, paddings and layout parameters

        EquipeAdapter.ViewHolder vh = new EquipeAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull EquipeAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        holder.tv_team_name.setText(equipeList.get(position).getNomEquipe());
        String image_url = equipeList.get(position).getImageEquipe();
        String picUrl=BASE_URL+image_url;

        Glide.with(holder.img_team_badge.getContext())
                .load(picUrl)
                .thumbnail(0.70f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img_team_badge);



/*
		int loader = 0;
        String image_url = metList.get(position).getPic();
		String picUrl=URL_IMAGE_SERVER+image_url;
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(image_url);
		ImageLoader imgLoader = new ImageLoader(context);
		imgLoader.DisplayImage(picUrl, loader, holder.ivPic); */


        //Picasso.with(context).load(image_url).into(holder.ivPic);

        lastPosition = position;

    }

    @Override
    public int getItemCount() {
        return equipeList == null ? (0) : equipeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView tv_team_name;
        public ImageView img_team_badge;


        public ViewHolder(View v) {
            super(v);
            tv_team_name = (TextView)v.findViewById(R.id.tv_team_name);
            img_team_badge = (ImageView)v.findViewById(R.id.img_team_badge);
            /*tvIdMet = (TextView)v.findViewById(R.id.tv_id_met);
            tvNomMet = (TextView) v.findViewById(R.id.tv_nom_met);
            tvPrixUnitaire = (TextView) v.findViewById(R.id.tv_prix_unitaire);
            tvTps_cuisson = (TextView) v.findViewById(R.id.tv_tps_cuisson);
            ivPic = (ImageView) v.findViewById(R.id.iv_pic);*/
        }
    }
}
