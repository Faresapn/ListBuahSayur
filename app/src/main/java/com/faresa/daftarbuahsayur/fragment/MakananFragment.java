package com.faresa.daftarbuahsayur.fragment;

import android.content.Context;
import android.net.Uri;
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
import com.faresa.daftarbuahsayur.Adapter.AdapterMakanan;
import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.MakananResponse;
import com.faresa.daftarbuahsayur.R;
import com.faresa.daftarbuahsayur.koneksi.Client;
import com.faresa.daftarbuahsayur.koneksi.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MakananFragment extends Fragment {
    AdapterMakanan adapterMakanan;
    private RecyclerView recyclerView;
    private List<MakananResponse> mList = new ArrayList<>();
    TextView td;
    ImageView iv;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_makanan, container, false);
        adapterMakanan = new AdapterMakanan(getContext(), mList);
        recyclerView = v.findViewById(R.id.recycleMakanan);
        recyclerView.setAdapter(adapterMakanan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        init();
        return v;
    }

    private void init() {
        Service service = Client.getClient().create(Service.class);

        Call<List<MakananResponse>> eventCall = service.getMakanan();
        eventCall.enqueue(new Callback<List<MakananResponse>>() {
            private Response<List<MakananResponse>> response;

            @Override
            public void onResponse(Call<List<MakananResponse>> call, Response<List<MakananResponse>> response) {
                this.response = response;
                if (response.isSuccessful()) {
                    List<MakananResponse> responseList = response.body();
                    mList.addAll(responseList);
                    adapterMakanan.notifyDataSetChanged();
                    Log.d("cfdvgbhnjkml", String.valueOf(adapterMakanan.getItemCount()));
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<MakananResponse>> call, Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }

}
