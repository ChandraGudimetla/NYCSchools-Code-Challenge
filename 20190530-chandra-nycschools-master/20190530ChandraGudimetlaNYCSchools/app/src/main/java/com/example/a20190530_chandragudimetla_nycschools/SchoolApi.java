package com.example.a20190530_chandragudimetla_nycschools;

import com.example.a20190530_chandragudimetla_nycschools.data.School;
import com.example.a20190530_chandragudimetla_nycschools.data.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SchoolApi {
    @GET("97mf-9njv.json")
    Call<List<School>> getSchools();

    @GET("f9bf-2cp4.json")
    Call<List<Score>> getScores();
}
