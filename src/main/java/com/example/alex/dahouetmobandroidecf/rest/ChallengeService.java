package com.example.alex.dahouetmobandroidecf.rest;

import com.example.alex.dahouetmobandroidecf.Model.Challenge;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alex on 08/11/17.
 */

public interface ChallengeService {

    @GET("/challenge")
    Call<List<Challenge>> listChallenge();


}
