package com.example.gadsleaderboard.UI.main;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.pojo.Leader_hours_model;
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.ArrayList;
import java.util.List;

public class Leader_adapter extends RecyclerView.Adapter<Leader_adapter.Leader_Holder> {
private List<Leader_hours_model> leader_models=new ArrayList<>();

   public void set_leader_list(List<Leader_hours_model> leader_list){
       leader_models=leader_list;
       notifyDataSetChanged();
   }

    @NonNull
    @Override
    public Leader_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderitem,parent,false);
        return new Leader_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Leader_Holder holder, int position) {
        Leader_hours_model leader_hours_model=leader_models.get(position);
       String statement =leader_hours_model.getHours()+" learning hours, "+leader_hours_model.getCountry();
        holder.name.setText(leader_hours_model.getName());
        holder.score.setText(statement);

    }

    @Override
    public int getItemCount() {
        return leader_models.size();
    }

    public class Leader_Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView score;
        ImageView badge;

        public Leader_Holder(@NonNull View itemView) {
            super(itemView);
            badge=itemView.findViewById(R.id.leader_badge);
            score=itemView.findViewById(R.id.leader_score);
            name=itemView.findViewById(R.id.leader_name);
        }
    }
}
