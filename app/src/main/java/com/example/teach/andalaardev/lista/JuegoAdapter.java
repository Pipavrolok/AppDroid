package com.example.teach.andalaardev.lista;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Juego model = listJuego.get(position);

        try{
            holder.Jtitulo.setText(model.getTitulo());
            holder.Jdescripcion.setText(model.getDescripcion());
            holder.Jprecio.setText("$ "+model.getPrecio().toString());
            holder.JImgJuego.setImageResource(R.drawable.meg);

        }catch (Exception e){
            e.printStackTrace();
        }
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