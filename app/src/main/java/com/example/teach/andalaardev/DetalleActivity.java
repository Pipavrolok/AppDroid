package com.example.teach.andalaardev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.teach.andalaardev.interfaces.IUser;
import com.example.teach.andalaardev.lista.ResponseUser;
import com.example.teach.andalaardev.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleActivity extends AppCompatActivity {
    //Textos del getExtra
    private String str_titulo,str_descripcion,str_img,str_precio,str_categoria,str_idVendedor;
    ImageView apLayout;
    TextView txt_titulo,txt_descripcion;
    Button txt_categoria;


    Button btn_prec;
    FloatingActionButton btn_correo,btn_telefono;
    public String uCorreo,uNombre,uRut,uTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str_titulo = getIntent().getStringExtra("titulo");
        setTitle(str_titulo);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* imagen*/
        str_img = getIntent().getStringExtra("imagen");
        apLayout = (ImageView) findViewById(R.id.img_parallax);
        String url = "http://www.digisat.cl/AndalaarDev/images/"+str_img;
        Glide.with(getApplicationContext()).load(url).into(apLayout);
        /* Fin imagen */


        str_descripcion = getIntent().getStringExtra("descripcion");
        str_categoria = getIntent().getStringExtra("categoria");
        str_precio = getIntent().getStringExtra("precio");


        txt_titulo = (TextView) findViewById(R.id.tv_titulo);
        txt_titulo.setText(str_titulo);


        txt_descripcion = (TextView) findViewById(R.id.tv_descripcion);
        txt_descripcion.setText(str_descripcion);


        txt_categoria = (Button) findViewById(R.id.btn_categoria);
        txt_categoria.setText(str_categoria);


        btn_prec = (Button) findViewById(R.id.btn_precio);
        btn_prec.setText("$ "+str_precio);

        str_idVendedor = getIntent().getStringExtra("idVendedor");
        IntentUsuario(str_idVendedor);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.user_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //inicializacion de botones de contacto
        btn_correo=(FloatingActionButton) findViewById(R.id.btn_correo);
        btn_telefono=(FloatingActionButton) findViewById(R.id.btn_call);

        btn_correo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(DetalleActivity.this,uCorreo, Toast.LENGTH_SHORT).show();
            }
        });

        btn_telefono.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String num = uTelefono;

                String uri = "tel:" + num.trim() ;
                Intent llama = new Intent(Intent.ACTION_DIAL);
                llama.setData(Uri.parse(uri));
                startActivity(llama);
            }
        });



    }

    private void IntentUsuario(String id_juego){

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

        IUser service = retrofit.create(IUser.class);

        Call<ResponseUser> call = service.getUser(id_juego);

        call.enqueue(new Callback<ResponseUser>() {

            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                //----------------------------Entró aqui---------------------------------------------
                if(response.code() ==200){
                    ResponseUser listUser = response.body();
                    Usuario user = listUser.getUsuario().get(0);
                    uRut = user.getRut();
                    uTelefono = user.getTelefono();
                    uCorreo = user.getEmail();
                    uNombre = user.getNombre();

                }else{
                    Toast.makeText(DetalleActivity.this,"Error de Carga", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toast.makeText(DetalleActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
