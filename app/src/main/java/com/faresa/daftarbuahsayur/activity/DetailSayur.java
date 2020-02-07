package com.faresa.daftarbuahsayur.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.SayurResponse;
import com.faresa.daftarbuahsayur.R;

import java.util.ArrayList;

public class DetailSayur extends AppCompatActivity {
    public static final String DATA_SAYUR = "data_sayur";
    ImageView gambarb;
    TextView namab;
    TextView keteranganb;
    SayurResponse sayurResponse;
    ArrayList<SayurResponse> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sayur);
        gambarb = findViewById(R.id.img_cover);
        namab = findViewById(R.id.tv_detail_namabwh);
        keteranganb = findViewById(R.id.tv_detail_keteranganbwh);

        sayurResponse = getIntent().getParcelableExtra(DATA_SAYUR);
        {

            String imageView1 = sayurResponse.getGambarsayur();
            String title1 = sayurResponse.getNamasayur();
            String synopsis1 = sayurResponse.getKeterangansayur();


            String image_url = imageView1;
            Log.d("asu", imageView1);

            Glide.with(this).load(image_url).placeholder(R.drawable.ic_launcher_background).into(gambarb);
            namab.setText(title1);
            keteranganb.setText(synopsis1);
        }

    }
}
