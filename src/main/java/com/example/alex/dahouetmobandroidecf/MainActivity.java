package com.example.alex.dahouetmobandroidecf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.dahouetmobandroidecf.Model.Challenge;
import com.example.alex.dahouetmobandroidecf.Model.Regate;
import com.example.alex.dahouetmobandroidecf.rest.ChallengeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    List<Regate> regates = new ArrayList<>();
    public static final String ENDPOINT = "http://10.105.49.39:8000/";
    public static Retrofit retrofit = null;
    public static List<Challenge> challenges = new ArrayList<>();
    public static ListView listChall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listChall = (ListView) findViewById(R.id.listViewChallenge);
        connectAndGetApiData();

    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ChallengeService challengeService = retrofit.create(ChallengeService.class);
        Call<List<Challenge>> callSerie = challengeService.listChallenge();

        callSerie.enqueue(new Callback<List<Challenge>>() {
            @Override
            public void onResponse(Call<List<Challenge>> call, Response<List<Challenge>> response) {
                challenges = response.body();
                listChall.setAdapter(new ArrayAdapter<Challenge>(MainActivity.this, android.R.layout.simple_list_item_1, challenges));
                listChall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Challenge cha = (Challenge) listChall.getItemAtPosition(position);
                        int idchall = cha.getId_challenge();
                        System.out.println(idchall);
                        Intent i = new Intent(MainActivity.this, ListeRegate.class);
                        i.putExtra("idchall", idchall);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Challenge>> call, Throwable t) {
                Log.e(MainActivity.class.getName(), "blabla", t);
            }
        });
    }

}