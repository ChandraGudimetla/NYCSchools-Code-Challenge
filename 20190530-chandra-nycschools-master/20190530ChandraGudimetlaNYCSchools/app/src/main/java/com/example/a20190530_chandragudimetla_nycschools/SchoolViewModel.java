package com.example.a20190530_chandragudimetla_nycschools;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.a20190530_chandragudimetla_nycschools.data.School;
import com.example.a20190530_chandragudimetla_nycschools.data.Score;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.Retrofit.*;

public class SchoolViewModel extends ViewModel {

    private static final String BASE_URL = "https://data.cityofnewyork.us/resource/";
    private static final String TAG = SchoolViewModel.class.getSimpleName();

    private MutableLiveData<List<School>> schools;
    private MutableLiveData<School> school = new MutableLiveData<>();
    private MutableLiveData<List<Score>> scores;
    private MutableLiveData<Score> score = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();


    public MutableLiveData<List<School>> getSchools() {
        if (schools == null) {
            schools = new MutableLiveData<>();
            loadSchool();
        }
        return schools;
    }

    public MutableLiveData<School> getSchool() {
        return school;
    }

    public void setSchool(School school) {
        Log.d(TAG, "setSchool: " + school.getSchoolName());
        this.school.setValue(school);
    }

    //Retrofit instance for schools
    private void loadSchool() {
        Retrofit retrofit = new Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SchoolApi schoolApi = retrofit.create(SchoolApi.class);

        Call<List<School>> listCall = schoolApi.getSchools();
        listCall.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schools.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                setErrorMessage(t.getMessage());
            }
        });
    }

    public MutableLiveData<List<Score>> getScores() {
        if (scores == null) {
            scores = new MutableLiveData<>();
            loadScores();
        }
        return scores;
    }

    public MutableLiveData<Score> getScore() {
        return score;
    }

    public void setScore(Score score) {
        Log.d(TAG, "detScore: " + school);
        this.score.setValue(score);
    }

    //Retrofit instance for scores
    private void loadScores() {
        Retrofit retrofit = new Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SchoolApi schoolApi = retrofit.create(SchoolApi.class);

        Call<List<Score>> listCall = schoolApi.getScores();
        listCall.enqueue(new Callback<List<Score>>() {
            @Override
            public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {
                scores.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Score>> call, Throwable t) {
                setErrorMessage(t.getMessage());
            }
        });
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage.setValue(errorMessage);
    }
}

