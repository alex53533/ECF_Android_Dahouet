package com.example.alex.dahouetmobandroidecf.rest;

import com.example.alex.dahouetmobandroidecf.Model.Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by alex on 08/11/17.
 */

public interface DetailsService {
    @GET("/regate/1")
    Call<List<Details>> listDetails();
}
