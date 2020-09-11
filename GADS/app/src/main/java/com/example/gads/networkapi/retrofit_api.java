package com.example.gads.networkapi;

import com.example.gads.models.learner;
import com.example.gads.models.skill_iq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface retrofit_api {

    @GET("/api/hours")
    Call<List<learner>> getTop_learners();

    @GET("/api/skilliq")
    Call<List<skill_iq>> getTop_SkillIQ_learners();

}
