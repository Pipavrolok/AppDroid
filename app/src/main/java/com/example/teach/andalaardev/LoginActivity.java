package com.example.teach.andalaardev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                if (usuario.getText().toString().equals("admin") &&
                        pass.getText().toString().equals("1234")  ){
                    Toast toastverdadero =
                            Toast.makeText(getApplicationContext(),
                                    "LOGEADO", Toast.LENGTH_SHORT);
                    Intent ListaJuegos = new Intent(getApplicationContext(), ListaActivity.class);
                    startActivity(ListaJuegos);

                    toastverdadero.show();
                }else{
                    Toast toastfalso =
                            Toast.makeText(getApplicationContext(),
                                    "INCORRECTO", Toast.LENGTH_SHORT);

                    toastfalso.show();
                }
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
}
