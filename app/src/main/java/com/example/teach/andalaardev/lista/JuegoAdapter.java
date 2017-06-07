package com.example.teach.andalaardev.lista;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teach.andalaardev.R;
import com.example.teach.andalaardev.models.Juego;

import java.util.ArrayList;


public class JuegoAdapter extends RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder>{
    private ArrayList<Juego> itemJuego;

    public JuegoAdapter(ArrayList<Juego> itemJuego) {
        this.itemJuego = itemJuego;
    }

    @Override
    public JuegoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View vista= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_juego,viewGroup,false);
        JuegoViewHolder juegoHolder= new JuegoViewHolder(vista);
        return juegoHolder;
    }

    @Override
    public void onBindViewHolder(JuegoViewHolder productoViewHolder, int i) {
        productoViewHolder.titulo.setText(itemJuego.get(i).getTitulo());
        productoViewHolder.precio.setText("$ "+itemJuego.get(i).getPrecio().toString());
        productoViewHolder.descripcion.setText(itemJuego.get(i).getDescripcion());
        productoViewHolder.imagen.setImageResource(R.drawable.meg);

    }

    @Override
    public int getItemCount() {
        return itemJuego.size();
    }

    public class JuegoViewHolder extends RecyclerView.ViewHolder{
        TextView titulo,precio,descripcion;
        ImageView imagen;

        public JuegoViewHolder(View itemView) {
            super(itemView);

            titulo=(TextView)itemView.findViewById(R.id.lblTitulo);
            precio=(TextView)itemView.findViewById(R.id.btn_precio);
            descripcion=(TextView)itemView.findViewById(R.id.lblDescripcion);
            imagen=(ImageView)itemView.findViewById(R.id.imgProducto);

        }
    }

}
