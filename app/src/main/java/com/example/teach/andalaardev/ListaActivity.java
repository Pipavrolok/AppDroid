package com.example.teach.andalaardev;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.teach.andalaardev.lista.JuegoAdapter;
import com.example.teach.andalaardev.lista.ResponseJuego;
import com.example.teach.andalaardev.models.Juego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    private RecyclerView recycler;
    private JuegoAdapter dataAdapter;
    private List<Juego> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        progressDialog = new ProgressDialog(this);

        //Ejecutar datos -Acuerdate
        progressDialog.setTitle("Generando Datos");
        progressDialog.setMessage("Cargando ...");
        progressDialog.show();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://monsterlabs.cl/AndalaarDev/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IJuego service = retrofit.create(IJuego.class);

        Call<ResponseJuego> call = service.getAllDataJuego();

        call.enqueue(new Callback<ResponseJuego>() {

            @Override
            public void onResponse(Call<ResponseJuego> call, Response<ResponseJuego> response) {
                //----------------------------Entró aqui---------------------------------------------
                if(response.code() ==200){
                    ResponseJuego listFJuego = response.body();
                    JuegoAdapter listaJuegoAdapter = new JuegoAdapter(listFJuego.getJuego(),ListaActivity.this);
                    recycler.setLayoutManager(new LinearLayoutManager(ListaActivity.this));
                    recycler.setItemAnimator(new DefaultItemAnimator());
                    recycler.setAdapter(listaJuegoAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(ListaActivity.this,"Error de Carga", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseJuego> call, Throwable t) {
                Toast.makeText(ListaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }


}