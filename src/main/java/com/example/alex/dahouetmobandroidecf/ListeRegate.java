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
import com.example.alex.dahouetmobandroidecf.rest.RegateService;

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

public class ListeRegate extends AppCompatActivity {
    List<Challenge> challenges = new ArrayList<>();
    public static final String ENDPOINT =  "http://10.105.49.39:8000/";
    public static Retrofit retrofit = null;
    public static List<Regate> regates = new ArrayList<>();
    public static ListView listReg = null;
    private int idchall = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Intent intent = getIntent();
        idchall = intent.getIntExtra("idchall", 0);
        listReg = (ListView) findViewById(R.id.listViewRegate);
        connectAndGetApiData();

    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        RegateService regateService = retrofit.create(RegateService.class);
        Call<List<Regate>> callSerie = regateService.listRegate(idchall);

        callSerie.enqueue(new Callback<List<Regate>>() {
            @Override
            public void onResponse(Call<List<Regate>> call, Response<List<Regate>> response) {
                regates = response.body();
                System.out.println(regates);
                listReg.setAdapter(new ArrayAdapter<Regate>(ListeRegate.this, android.R.layout.simple_list_item_1, regates));
                listReg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Regate reg = (Regate) listReg.getItemAtPosition(position);
                        int idreg = reg.getId_regate();
                        Intent i = new Intent(ListeRegate.this, DetailsRegate.class);
                        i.putExtra("idreg", idreg);
                        startActivity(i);
                    }
                });
            }


            @Override
            public void onFailure(Call<List<Regate>> call, Throwable t) {
                Log.e(ListeRegate.class.getName(), "blabla", t);
            }
        });
    }
}
