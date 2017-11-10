package com.example.alex.dahouetmobandroidecf.MethodAPI;

import android.os.AsyncTask;

import com.example.alex.dahouetmobileecf.Config.ApiConfig;
import com.example.alex.dahouetmobileecf.Model.Regate;
import com.example.alex.dahouetmobileecf.Model.Resultat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class FindResultatByRegate extends AsyncTask<String, Void, List<Resultat>> {

    private final String link = ApiConfig.resultatsbyregate;

    @Override
    protected List<Resultat> doInBackground(String... params) {
        List<Resultat> resultats = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;

        try {
            URL url = new URL(link + params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(9999);
            urlConnection.setConnectTimeout(9999);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "dahouetmobileecf");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
            //recherhe evenement effectué

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

            } else {
                System.out.println("Erreur recherche regate");
            }
            urlConnection.disconnect();

            JSONArray jsonArray = new JSONArray(sb.toString());

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id_voilier = jsonObject.getInt("id_voilier");
                String nom_voilier = jsonObject.getString("nom_voilier");
                String num_voilier = jsonObject.getString("num_voilier");
                int place = jsonObject.getInt("place");
                int temps_reel = jsonObject.getInt("temps_reel");
                int temps_compense = jsonObject.getInt("temps_compense");

                Score sco = new Score(id_voilier, nom_voilier, num_voilier, place, temps_reel, temps_compense);

                scores.add(sco);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultats;
    }

    private static Date convertDate(String str) {
        DateFormat formatter = null;
        Date convertedDate = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            convertedDate = (Date) formatter.parse(str);
        } catch (ParseException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convertedDate;
    }
}

