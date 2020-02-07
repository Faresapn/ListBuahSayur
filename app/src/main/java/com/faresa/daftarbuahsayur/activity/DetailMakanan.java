package com.faresa.daftarbuahsayur.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.MakananResponse;
import com.faresa.daftarbuahsayur.R;

import java.util.ArrayList;

public class DetailMakanan extends AppCompatActivity {
    public static final String DATA_MAKANAN = "data_makanan";
    ImageView gambarb;
    TextView namab;
    TextView keteranganb;
    MakananResponse makananResponse;
    ArrayList<MakananResponse> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        gambarb = findViewById(R.id.img_cover);
        namab = findViewById(R.id.tv_detail_namabwh);
        keteranganb = findViewById(R.id.tv_detail_keteranganbwh);

        makananResponse = getIntent().getParcelableExtra(DATA_MAKANAN);
        {

            String imageView1 = makananResponse.getGambarmakanan();
            String title1 = makananResponse.getNamamakanan();
            String synopsis1 = makananResponse.getKeteranganmakanan();


            String image_url = imageView1;
            Log.d("asu", imageView1);

            Glide.with(this).load(image_url).placeholder(R.drawable.ic_launcher_background).into(gambarb);
            namab.setText(title1);
            keteranganb.setText(synopsis1);
        }
    }
}
