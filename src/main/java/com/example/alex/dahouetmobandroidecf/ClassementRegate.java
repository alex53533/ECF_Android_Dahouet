package com.example.alex.dahouetmobandroidecf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.dahouetmobandroidecf.Model.Challenge;
import com.example.alex.dahouetmobandroidecf.Model.Classement;
import com.example.alex.dahouetmobandroidecf.rest.ClassementService;

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

public class ClassementRegate extends AppCompatActivity {
    //Bundle idDet = getIntent().getExtras();
    List<Challenge> challenges = new ArrayList<>();
    public static final String ENDPOINT =  "http://10.105.49.39:8000/";
    public static Retrofit retrofit = null;
    public static List<Classement> classements = new ArrayList<>();
    public static ListView listClass = null;
    public static int iddet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_resultat_regate);
        Intent intent = getIntent();
        iddet = intent.getIntExtra("iddet", 0);
        listClass = (ListView) findViewById(R.id.listViewResultat);
        connectAndGetApiData();


    }
    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ClassementService classementService = retrofit.create(ClassementService.class);
        Call<List<Classement>> callSerie = classementService.listClassement(iddet);

        callSerie.enqueue(new Callback<List<Classement>>() {
            @Override
            public void onResponse(Call<List<Classement>> call, Response<List<Classement>> response) {
                classements = response.body();
                listClass.setAdapter(new ArrayAdapter<Classement>(ClassementRegate.this, android.R.layout.simple_list_item_1, classements));
                /*listClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Classement class = (Regate) listClass.getItemAtPosition(position);
                        int idclass = class.getId_voilier();
                        Intent i = new Intent(ClassementRegate.this, MainActivity.class);
                        i.putExtra("idclass", idclass);
                        startActivity(i);
                    }
                });*/
            }

            @Override
            public void onFailure(Call<List<Classement>> call, Throwable t) {

            }
        });
    }
}
