package com.faresa.daftarbuahsayur.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.faresa.daftarbuahsayur.Adapter.AdapterBuah;
import com.faresa.daftarbuahsayur.Adapter.AdapterSayur;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.SayurResponse;
import com.faresa.daftarbuahsayur.R;
import com.faresa.daftarbuahsayur.koneksi.Client;
import com.faresa.daftarbuahsayur.koneksi.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SayurFragment extends Fragment {


    public SayurFragment() {
        // Required empty public constructor
    }
     AdapterSayur adapterSayur;
    private RecyclerView recyclerView;
    private List<SayurResponse> mList = new ArrayList<>();
    TextView td;
    ImageView iv;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sayur, container, false);
        adapterSayur = new AdapterSayur(getContext(), mList);
        recyclerView = v.findViewById(R.id.recycleSayur);
        recyclerView.setAdapter(adapterSayur);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        init();
        return v;
    }

    private void init() {
        Service service = Client.getClient().create(Service.class);

        Call<List<SayurResponse>> eventCall = service.getSayur();
        eventCall.enqueue(new Callback<List<SayurResponse>>() {
            private Response<List<SayurResponse>> response;

            @Override
            public void onResponse(Call<List<SayurResponse>> call, Response<List<SayurResponse>> response) {
                this.response = response;
                if (response.isSuccessful()) {
                    List<SayurResponse> responseList = response.body();
                    mList.addAll(responseList);
                    adapterSayur.notifyDataSetChanged();
                    Log.d("cfdvgbhnjkml", String.valueOf(adapterSayur.getItemCount()));
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<SayurResponse>> call, Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }

}
