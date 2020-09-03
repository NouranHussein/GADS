package com.example.gadsleaderboard.UI.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.pojo.Leader_hours_model;

import java.util.List;

public class leaderboardFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    Leader_adapter leader_adapter;
   public leaderboardFragment (){

   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.leaderboardfragment,container,false);
        recyclerView=v.findViewById(R.id.leader_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(leader_adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leader_adapter=new Leader_adapter();
        GAD_ViewModel gad_viewModel=new ViewModelProvider(this).get(GAD_ViewModel.class);
       gad_viewModel.get_hour_leaders();
        gad_viewModel.leader_hour_livedata.observe(this, new Observer<List<Leader_hours_model>>() {
            @Override
            public void onChanged(List<Leader_hours_model> leader_hours_models) {
                leader_adapter.set_leader_list(leader_hours_models);

            }
        });

    }
}
