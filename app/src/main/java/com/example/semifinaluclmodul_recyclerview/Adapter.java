package com.example.semifinaluclmodul_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Model> models;
    private OnItemClickListener fListener;

    private int orientasi;

    public int getOrientasi() {
        return orientasi;
    }

    public void setOrientasi(int orien) {
        this.orientasi = orien;
    }

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.fListener = listener;
    }

    public Adapter(Context context) {
        this.context = context;
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow;
        // jika vertical
        if (getOrientasi()==0) itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_football,viewGroup,false);
            // jika horizontal
        else if (getOrientasi()==1) itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_football,viewGroup,false);
            // jika grid
        else if (getOrientasi()==2) itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_football_grid,viewGroup,false);
            // default
        else  itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_football,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getModels().get(i).getLambangTeam()).into(viewHolder.ivLambangTeam);
        viewHolder.tvNamaTeam.setText(getModels().get(i).getNamaTeam());
    }

    @Override
    public int getItemCount() {
        return getModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLambangTeam;
        private TextView tvNamaTeam;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivLambangTeam = itemView.findViewById(R.id.lambang_team);
            tvNamaTeam = itemView.findViewById(R.id.nama_team);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        fListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
