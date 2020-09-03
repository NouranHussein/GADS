package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.pojo.Skill_iq_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface skill_iq_inteface {
    @GET("/api/skilliq")
    public Call<List<Skill_iq_model>> getSkillIQModel();
}
