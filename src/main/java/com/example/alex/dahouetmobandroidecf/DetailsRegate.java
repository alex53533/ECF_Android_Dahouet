package com.example.alex.dahouetmobandroidecf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.dahouetmobandroidecf.Model.Challenge;
import com.example.alex.dahouetmobandroidecf.Model.Details;
import com.example.alex.dahouetmobandroidecf.rest.DetailsService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alex on 08/11/17.
 */

public class DetailsRegate extends AppCompatActivity {
    List<Challenge> challenges = new ArrayList<>();
    public static final String ENDPOINT =  "http://10.105.49.39:8000/";
    public static Retrofit retrofit = null;
    public static List<Details> details = new ArrayList<>();
    public static ListView listDet = null;
    public static int idreg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_regate2);
        Intent intent = getIntent();
        idreg = intent.getIntExtra("idreg", 0);
        listDet = (ListView) findViewById(R.id.listViewDetails);
        connectAndGetApiData();

    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        DetailsService detailsService = retrofit.create(DetailsService.class);
        Call<List<Details>> callSerie = detailsService.listDetails();

        callSerie.enqueue(new Callback<List<Details>>() {
            @Override
            public void onResponse(Call<List<Details>> call, Response<List<Details>> response) {
                details = response.body();
                listDet.setAdapter(new ArrayAdapter<Details>(DetailsRegate.this, android.R.layout.simple_list_item_1, details));
                listDet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Details det = (Details) listDet.getItemAtPosition(position);
                        int iddet = det.getId_regate();
                        Intent i = new Intent(DetailsRegate.this, ClassementRegate.class);
                        i.putExtra("iddet", iddet);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Details>> call, Throwable t) {

            }
        });
    }
}
