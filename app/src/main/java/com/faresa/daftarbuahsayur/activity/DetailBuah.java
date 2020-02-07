package com.faresa.daftarbuahsayur.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.R;

import java.util.ArrayList;

/*created By FARESA PN */

public class DetailBuah extends AppCompatActivity {
    public static final String DATA_BUAH = "data_buah";
    ImageView gambarb;
    TextView namab;
    TextView keteranganb;
    BuahResponse buah;
    ArrayList<BuahResponse> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_buah);

        gambarb = findViewById(R.id.img_cover);
        namab = findViewById(R.id.tv_detail_namabwh);
        keteranganb = findViewById(R.id.tv_detail_keteranganbwh);

        buah = getIntent().getParcelableExtra(DATA_BUAH);
        {

            String imageView1 = buah.getGambarbuah();
            String title1 = buah.getNamabuah();
            String synopsis1 = buah.getKeteranganbuah();


            String image_url = imageView1;
            Log.d("asu", imageView1);

            Glide.with(this).load(image_url).placeholder(R.drawable.ic_launcher_background).into(gambarb);
            namab.setText(title1);
            keteranganb.setText(synopsis1);
        }

    }

}