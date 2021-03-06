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
import com.faresa.daftarbuahsayur.Model.BuahResponse;
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
public class BuahFragment extends Fragment {


    public BuahFragment() {
        // Required empty public constructor
    }
    private AdapterBuah adapterBuah;
    private RecyclerView recyclerView;
    private List<BuahResponse> mList = new ArrayList<>();
    TextView td;
    ImageView iv;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_buah, container, false);
          adapterBuah = new AdapterBuah(getContext(), mList);
        recyclerView = v.findViewById(R.id.recycleBuah);
        recyclerView.setAdapter(adapterBuah);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        init();
        return v;
    }

    private void init() {
        Service service = Client.getClient().create(Service.class);

        Call<List<BuahResponse>> eventCall = service.getBuah();
        eventCall.enqueue(new Callback<List<BuahResponse>>() {
            private Response<List<BuahResponse>> response;

            @Override
            public void onResponse(Call<List<BuahResponse>> call, Response<List<BuahResponse>> response) {
                this.response = response;
                if (response.isSuccessful()) {
                    List<BuahResponse> responseList = response.body();
                    mList.addAll(responseList);
                    adapterBuah.notifyDataSetChanged();
                    Log.d("cfdvgbhnjkml", String.valueOf(adapterBuah.getItemCount()));
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<BuahResponse>> call, Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }

}
