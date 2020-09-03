package com.example.gadsleaderboard.UI.main;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.data.LeaderModelClient;
import com.example.gadsleaderboard.data.SkillModelClient;
import com.example.gadsleaderboard.pojo.Leader_hours_model;
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GAD_ViewModel extends ViewModel {
    MutableLiveData<List<Leader_hours_model>> leader_hour_livedata=new MutableLiveData<>();
     MutableLiveData<List<Skill_iq_model>> skill_iq_livedata=new MutableLiveData<>();

    public void get_hour_leaders(){
        LeaderModelClient.getINSTANCE().getLeaderHoursModel().enqueue(new Callback<List<Leader_hours_model>>() {
            @Override
            public void onResponse(Call<List<Leader_hours_model>> call, Response<List<Leader_hours_model>> response) {
                leader_hour_livedata.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Leader_hours_model>> call, Throwable t) {

            }
        });


    }
    public void get_skill_iq(){
        SkillModelClient.getINSTANCE().getSkillIQModel().enqueue(new Callback<List<Skill_iq_model>>() {
            @Override
            public void onResponse(Call<List<Skill_iq_model>> call, Response<List<Skill_iq_model>> response) {
                skill_iq_livedata.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Skill_iq_model>> call, Throwable t) {

            }
        });
    }

}
