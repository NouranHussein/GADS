package com.example.gadsleaderboard.UI.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SkilI_IQ_adapter extends RecyclerView.Adapter<SkilI_IQ_adapter.Skill_View_Holder> {
private List<Skill_iq_model> skill_iq_models=new ArrayList<>();

    public void set_SkilI_IQ_list(List<Skill_iq_model> skill_iq_models) {
        this.skill_iq_models = skill_iq_models;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Skill_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.skilliqitem,parent,false);
        return new Skill_View_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Skill_View_Holder holder, int position) {
        Skill_iq_model skill_iq_model=skill_iq_models.get(position);
       String statement =skill_iq_model.getScore()+" skill IQ Score, "+skill_iq_model.getCountry();

        holder.name.setText(skill_iq_model.getName());
        holder.score.setText(statement);

    }

    @Override
    public int getItemCount() {
        return skill_iq_models.size();
    }

    public class Skill_View_Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView score;
        ImageView badge;

        public Skill_View_Holder(@NonNull View itemView) {
            super(itemView);
            badge=itemView.findViewById(R.id.skill_badge);
            score=itemView.findViewById(R.id.skill_score_tv);
            name=itemView.findViewById(R.id.skill_name_tv);
        }
    }


}
