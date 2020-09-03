package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.pojo.Leader_hours_model;
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderModelClient {
    private static String BASE_URL="https://gadsapi.herokuapp.com";
    private leader_hours_interface leader_hours;
    private static LeaderModelClient INSTANCE;
    public LeaderModelClient(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        leader_hours=retrofit.create(leader_hours_interface.class);
    }

    public static LeaderModelClient getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new LeaderModelClient();
        }
        return INSTANCE;
    }
    public Call<List<Leader_hours_model>> getLeaderHoursModel(){
        return leader_hours.getLeaderHoursModel();
    }
}
