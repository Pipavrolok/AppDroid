package com.example.teach.andalaardev;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teach.andalaardev.interfaces.ILogin;
import com.example.teach.andalaardev.models.ResponseLogin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class LoginActivity extends AppCompatActivity implements Animation.AnimationListener{

    //inicializacion variables a usar
    private ImageView img_banner;
    private ImageView img_ico;
    private TextView bienvenida;
    private TextView usuario;
    private TextView pass;
    private Button ingresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //LLenado de Campos
        img_banner = (ImageView) findViewById(R.id.banner_iv);
        img_ico = (ImageView) findViewById(R.id.ico_iv);
        bienvenida = (TextView) findViewById(R.id.bienvenida);
        usuario = (TextView) findViewById(R.id.txt_user);
        pass = (TextView) findViewById(R.id.txt_pass);
        ingresar = (Button) findViewById(R.id.btn_ingresar);

        //Se esconden Elementos
        img_banner.setVisibility(View.GONE);
        bienvenida.setVisibility(View.GONE);
        usuario.setVisibility(View.GONE);
        pass.setVisibility(View.GONE);
        ingresar.setVisibility(View.GONE);

        //inicio de animacion
        Animation icon_animacion = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.transicion_icono);
        icon_animacion.setFillAfter(true);
        icon_animacion.setAnimationListener(this);
        img_ico.startAnimation(icon_animacion);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Proceso de login
                doLogin();

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        //Se Muestran Elementos cuando termina animacion
        img_banner.setAlpha(0f);
        img_banner.setVisibility(View.VISIBLE);
        bienvenida.setAlpha(0f);
        bienvenida.setVisibility(View.VISIBLE);
        usuario.setAlpha(0f);
        usuario.setVisibility(View.VISIBLE);
        pass.setAlpha(0f);
        pass.setVisibility(View.VISIBLE);
        ingresar.setAlpha(0f);
        ingresar.setVisibility(View.VISIBLE);

        int tiempoAnimacion = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        img_banner.animate()
                .alpha(1f)
                .setDuration(tiempoAnimacion)
                .setListener(null);
        bienvenida.animate()
                .alpha(1f)
                .setDuration(tiempoAnimacion)
                .setListener(null);
        usuario.animate()
                .alpha(1f)
                .setDuration(tiempoAnimacion)
                .setListener(null);
        pass.animate()
                .alpha(1f)
                .setDuration(tiempoAnimacion)
                .setListener(null);
        ingresar.animate()
                .alpha(1f)
                .setDuration(tiempoAnimacion)
                .setListener(null);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void doLogin() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vivo.duoc.cl/VivoMobileServer/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ILogin service = retrofit.create(ILogin.class);

        Call<ResponseLogin> repos = service.login(usuario.getText().toString(),
                pass.getText().toString());
        repos.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.code() == 200) {
                    ResponseLogin values = response.body();

                    if (values.getPerfil().getNombreCompleto() != null){
                        Toast.makeText(LoginActivity.this, "Bienvenido: " + values.getPerfil().getNombreCompleto(), Toast.LENGTH_SHORT).show();
                        //Proceso de redireccion
                         MediaPlayer tusti = MediaPlayer.create(getApplicationContext(),R.raw.toast);
                        tusti.start();
                        Intent ListaJuegos = new Intent(getApplicationContext(), NaviActivity.class);
                        ListaJuegos.putExtra("correo",values.getPerfil().getEmailDuoc());
                        ListaJuegos.putExtra("nombre",values.getPerfil().getNombreCompleto());
                        startActivity(ListaJuegos);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
