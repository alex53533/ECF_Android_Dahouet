package com.example.alex.dahouetmobandroidecf.rest;

import com.example.alex.dahouetmobandroidecf.Model.Classement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alex on 08/11/17.
 */

public interface ClassementService {
    @GET("/participe/{id}")
    Call<List<Classement>> listClassement(@Path("id") int id);
}
