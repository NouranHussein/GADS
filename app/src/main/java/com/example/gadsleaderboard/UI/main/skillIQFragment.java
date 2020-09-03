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
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.ArrayList;
import java.util.List;

public class skillIQFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    SkilI_IQ_adapter skilI_iq_adapter;
   public skillIQFragment(){

   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.skilliqfragment,container,false);
       recyclerView=v.findViewById(R.id.skill_rv);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       recyclerView.setAdapter(skilI_iq_adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skilI_iq_adapter=new SkilI_IQ_adapter();
        GAD_ViewModel gad_viewModel=new ViewModelProvider(this).get(GAD_ViewModel.class);
        gad_viewModel.get_skill_iq();
        gad_viewModel.skill_iq_livedata.observe(this, skill_iq_models -> {
            skilI_iq_adapter.set_SkilI_IQ_list(skill_iq_models);
        });
            }
}
