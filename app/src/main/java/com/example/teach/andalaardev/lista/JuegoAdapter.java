package com.example.teach.andalaardev.lista;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.teach.andalaardev.DetalleActivity;
import com.example.teach.andalaardev.R;
import com.example.teach.andalaardev.models.Juego;

import java.util.List;

public class JuegoAdapter extends RecyclerView.Adapter<JuegoAdapter.ViewHolder>{

    private List<Juego> listJuego;
    private Context context;

    public JuegoAdapter(List<Juego> listJuego, Context context) {
        this.listJuego = listJuego;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_juego,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Juego model = listJuego.get(position);

        try{
            holder.Jtitulo.setText(model.getTitulo());
            holder.Jdescripcion.setText(model.getDescripcion());
            holder.Jprecio.setText("$ "+model.getPrecio().toString());

            String url = "http://www.digisat.cl/AndalaarDev/images/"+model.getImgJuego();
            Glide.with(context).load(url).into(holder.JImgJuego);

        }catch (Exception e){
            e.printStackTrace();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //modificar y crear Intent para enviar data a detalle.xml
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("titulo",model.getTitulo());
                intent.putExtra("descripcion",model.getDescripcion());
                intent.putExtra("precio",model.getPrecio().toString());
                intent.putExtra("categoria",model.getCategoria());
                intent.putExtra("imagen",model.getImgJuego());
                intent.putExtra("idVendedor",model.getIdVendedor());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJuego.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Jtitulo;
        private TextView Jdescripcion;
        private TextView Jprecio;
        private ImageView JImgJuego;

        public ViewHolder(View itemView) {

            super(itemView);
            Jtitulo = (TextView) itemView.findViewById(R.id.lblTitulo);
            Jdescripcion = (TextView) itemView.findViewById(R.id.lblDescripcion);
            Jprecio = (TextView) itemView.findViewById(R.id.btn_precio);
            JImgJuego = (ImageView) itemView.findViewById(R.id.imgJuego);
        }
    }
}