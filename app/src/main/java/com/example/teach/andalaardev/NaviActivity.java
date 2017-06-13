package com.example.teach.andalaardev;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.teach.andalaardev.interfaces.IJuego;
import com.example.teach.andalaardev.lista.JuegoAdapter;
import com.example.teach.andalaardev.lista.ResponseJuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NaviActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ProgressDialog progressDialog;

    private RecyclerView recycler;
    SwipeRefreshLayout swipeThis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        swipeThis = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        cargarLaData();
        //Barra modificarla
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floatin Agregar Juego
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar Juego", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        swipeThis.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                //refresh
                cargarLaData();
                Toast.makeText(NaviActivity.this, "actualizando data", Toast.LENGTH_SHORT).show();
                swipeThis.setRefreshing(false);
            }
        });
        

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void cargarLaData(){
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
                    JuegoAdapter listaJuegoAdapter = new JuegoAdapter(listFJuego.getJuego(),NaviActivity.this);
                    recycler.setLayoutManager(new LinearLayoutManager(NaviActivity.this));
                    recycler.setItemAnimator(new DefaultItemAnimator());
                    recycler.setAdapter(listaJuegoAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(NaviActivity.this,"Error de Carga", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseJuego> call, Throwable t) {
                Toast.makeText(NaviActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
