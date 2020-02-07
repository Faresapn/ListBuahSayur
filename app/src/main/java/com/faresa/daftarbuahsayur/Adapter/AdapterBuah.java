package com.faresa.daftarbuahsayur.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.faresa.daftarbuahsayur.activity.DetailBuah;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.R;

import java.util.List;

public class AdapterBuah extends RecyclerView.Adapter<AdapterBuah.ViewHolderMovie> {
    private Context context;
    private List<BuahResponse> list;

    public AdapterBuah(Context context, List<BuahResponse> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderMovie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_buah,viewGroup,false);
        return new ViewHolderMovie(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBuah.ViewHolderMovie viewHolderMovie, int i) {
        viewHolderMovie.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderMovie extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image_main;
        TextView title;
        public ViewHolderMovie(@NonNull View view) {
            super(view);

            title = view.findViewById(R.id.listNamaBuah);

            image_main = view.findViewById(R.id.listGambarBuah);
            view.setOnClickListener(this);
        }

        void bind(BuahResponse buah) {
            title.setText(buah.getNamabuah());

            Glide.with(itemView.getContext())
                    .load( buah.getGambarbuah())
                    .into(image_main);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            BuahResponse buah = list.get(position);
            Intent intent = new Intent(view.getContext(), DetailBuah.class);
            intent.putExtra(DetailBuah.DATA_BUAH,buah);
            view.getContext().startActivity(intent);
        }
    }
}