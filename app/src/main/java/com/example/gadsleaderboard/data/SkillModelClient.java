package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.pojo.Leader_hours_model;
import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SkillModelClient {
    private static final String BASE_URL="https://gadsapi.herokuapp.com";
    private skill_iq_inteface skilliq;
    private static SkillModelClient INSTANCE;
    public SkillModelClient(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        skilliq=retrofit.create(skill_iq_inteface.class);
    }

    public static SkillModelClient getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new SkillModelClient();
        }
        return INSTANCE;
    }

    public Call<List<Skill_iq_model>> getSkillIQModel(){
        return skilliq.getSkillIQModel();
    }
}
