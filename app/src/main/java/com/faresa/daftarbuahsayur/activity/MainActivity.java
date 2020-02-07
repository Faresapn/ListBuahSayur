package com.faresa.daftarbuahsayur.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.faresa.daftarbuahsayur.R;
import com.faresa.daftarbuahsayur.fragment.BuahFragment;
import com.faresa.daftarbuahsayur.fragment.MakananFragment;
import com.faresa.daftarbuahsayur.fragment.SayurFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
       Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener
            = menuItem -> {

        switch (menuItem.getItemId()) {
            case R.id.buah:
                moveFragment(new BuahFragment());
                break;

            case R.id.sayur:

                moveFragment(new SayurFragment());
                break;
            case R.id.makanan:
                moveFragment(new MakananFragment());
                break;

        }
        menuItem.setCheckable(true);
        menuItem.setChecked(true);
        return false;
    };

    @Override
    public void onClick(View v) {

    }

    void moveFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_layout, fragment);
        fragmentTransaction.commit();
    }

}
