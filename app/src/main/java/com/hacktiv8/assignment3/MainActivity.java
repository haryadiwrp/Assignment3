package com.hacktiv8.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView totalCases, totalRecovery, totalDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCases = findViewById(R.id.totalCases);
        totalDeaths = findViewById(R.id.totalDeaths);
        totalRecovery = findViewById(R.id.totalRecovery);
        getTotalCovidCases();

    }



    private  void getTotalCovidCases() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<CovidCases> covidCasesCall = RetrofitClient.getInstance().apiService().getCovidCases();
        //CovidCases covidCases = new CovidCases();
        covidCasesCall.enqueue(new Callback<CovidCases>() {
            @Override
            public void onResponse(Call<CovidCases> call, Response<CovidCases> response) {;
                CovidCases covidRespon = response.body();
                printCovid(covidRespon);
            }

            @Override
            public void onFailure(Call<CovidCases> call, Throwable t) {

            }
        });
    }

    private CovidCases recovery = new CovidCases();


    private void printCovid(CovidCases covidCases) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ").append(covidCases.getTotalCases()).append("\n");
        totalCases.setText(builder.toString());
        builder.setLength(0);

        builder.append(" ").append(covidCases.getTotalRecovery()).append("\n");
        totalRecovery.setText(builder.toString());
        builder.setLength(0);

        builder.append(" ").append(covidCases.getTotalDeaths()).append("\n");
        totalDeaths.setText(builder.toString());
        builder.setLength(0);
    }




}