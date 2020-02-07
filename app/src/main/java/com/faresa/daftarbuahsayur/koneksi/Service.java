package com.faresa.daftarbuahsayur.koneksi;

import com.faresa.daftarbuahsayur.Model.BuahResponse;
import com.faresa.daftarbuahsayur.Model.MakananResponse;
import com.faresa.daftarbuahsayur.Model.SayurResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/*created By FARESA PN */

public interface Service {


    @GET("lihat_buah.php")
    Call<List<BuahResponse>> getBuah();

    @GET("lihat_sayur.php")
    Call<List<SayurResponse>> getSayur();

    @GET("lihat_makanan.php")
    Call<List<MakananResponse>> getMakanan();


}
