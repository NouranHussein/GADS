package com.example.gadsleaderboard.data;

import com.example.gadsleaderboard.pojo.Leader_hours_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface leader_hours_interface {
    @GET("/api/hours")
    public Call<List<Leader_hours_model>>getLeaderHoursModel();
}
