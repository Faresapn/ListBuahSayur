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
import com.faresa.daftarbuahsayur.Model.MakananResponse;
import com.faresa.daftarbuahsayur.Model.SayurResponse;
import com.faresa.daftarbuahsayur.R;
import com.faresa.daftarbuahsayur.activity.DetailMakanan;
import com.faresa.daftarbuahsayur.activity.DetailSayur;

import java.util.List;

public class AdapterSayur extends RecyclerView.Adapter<AdapterSayur.ViewHolderSayur> {
    private Context context;
    private List<SayurResponse> list;

    public AdapterSayur (Context context, List<SayurResponse> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolderSayur onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_buah,viewGroup,false);
        return new AdapterSayur.ViewHolderSayur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSayur.ViewHolderSayur viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderSayur extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image_main;
        TextView title;
        public ViewHolderSayur(@NonNull View view) {
            super(view);

            title = view.findViewById(R.id.listNamaBuah);

            image_main = view.findViewById(R.id.listGambarBuah);
            view.setOnClickListener(this);
        }
        void bind(SayurResponse sayur) {
            title.setText(sayur.getNamasayur());

            Glide.with(itemView.getContext())
                    .load( sayur.getGambarsayur())
                    .into(image_main);
        }
        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            SayurResponse sayurResponse  = list.get(position);
            Intent intent = new Intent(v.getContext(), DetailSayur.class);
            intent.putExtra(DetailSayur.DATA_SAYUR,sayurResponse);
            v.getContext().startActivity(intent);

        }
    }
}
