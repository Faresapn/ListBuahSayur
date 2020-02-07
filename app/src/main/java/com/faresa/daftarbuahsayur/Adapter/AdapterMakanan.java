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
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.MakananResponse;
import com.faresa.daftarbuahsayur.R;
import com.faresa.daftarbuahsayur.activity.DetailBuah;
import com.faresa.daftarbuahsayur.activity.DetailMakanan;

import java.util.List;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolderMakanan> {
    private Context context;
    private List<MakananResponse> list;

    public AdapterMakanan (Context context, List<MakananResponse> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderMakanan onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_buah,viewGroup,false);
        return new ViewHolderMakanan(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMakanan.ViewHolderMakanan viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderMakanan extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image_main;
        TextView title;
        public ViewHolderMakanan(@NonNull View view) {
            super(view);

            title = view.findViewById(R.id.listNamaBuah);

            image_main = view.findViewById(R.id.listGambarBuah);
            view.setOnClickListener(this);
        }
        void bind(MakananResponse makanan) {
            title.setText(makanan.getNamamakanan());

            Glide.with(itemView.getContext())
                    .load( makanan.getGambarmakanan())
                    .into(image_main);
        }
        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            MakananResponse makananResponse  = list.get(position);
            Intent intent = new Intent(v.getContext(), DetailMakanan.class);
            intent.putExtra(DetailMakanan.DATA_MAKANAN,makananResponse);
            v.getContext().startActivity(intent);

        }
    }
}
