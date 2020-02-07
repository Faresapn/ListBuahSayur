package com.faresa.daftarbuahsayur.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*created By FARESA PN */


public class BuahResponse implements Parcelable {

	@SerializedName("gambarbuah")
	@Expose
	private String gambarbuah;
	@SerializedName("namabuah")
	@Expose
	private String namabuah;
	@SerializedName("keteranganbuah")
	@Expose
	private String keteranganbuah;



	public void setGambarbuah(String gambarbuah){
		this.gambarbuah = gambarbuah;
	}

	public String getGambarbuah(){
		return gambarbuah;
	}

	public void setNamabuah(String namabuah){
		this.namabuah = namabuah;
	}

	public String getNamabuah(){
		return namabuah;
	}

	public void setKeteranganbuah(String keteranganbuah){
		this.keteranganbuah = keteranganbuah;
	}

	public String getKeteranganbuah(){
		return keteranganbuah;
	}

	@Override
 	public String toString(){
		return 
			"BuahResponse{" +
			"gambarbuah = '" + gambarbuah + '\'' + 
			",namabuah = '" + namabuah + '\'' + 
			",keteranganbuah = '" + keteranganbuah + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.gambarbuah);
		dest.writeString(this.namabuah);
		dest.writeString(this.keteranganbuah);
	}
	protected BuahResponse(Parcel in) {
		this.gambarbuah = in.readString();
		this.namabuah = in.readString();
		this.keteranganbuah = in.readString();
	}

	public static final Creator<BuahResponse> CREATOR = new Creator<BuahResponse>() {
		@Override
		public BuahResponse createFromParcel(Parcel in) {
			return new BuahResponse(in);
		}

		@Override
		public BuahResponse[] newArray(int size) {
			return new BuahResponse[size];
		}
	};
}
