package com.faresa.daftarbuahsayur.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MakananResponse implements Parcelable {

	@SerializedName("keteranganmakanan")
	private String keteranganmakanan;

	@SerializedName("gambarmakanan")
	private String gambarmakanan;

	@SerializedName("namamakanan")
	private String namamakanan;



	public void setKeteranganmakanan(String keteranganmakanan){
		this.keteranganmakanan = keteranganmakanan;
	}

	public String getKeteranganmakanan(){
		return keteranganmakanan;
	}

	public void setGambarmakanan(String gambarmakanan){
		this.gambarmakanan = gambarmakanan;
	}

	public String getGambarmakanan(){
		return gambarmakanan;
	}

	public void setNamamakanan(String namamakanan){
		this.namamakanan = namamakanan;
	}

	public String getNamamakanan(){
		return namamakanan;
	}

	@Override
 	public String toString(){
		return 
			"MakananResponse{" + 
			"keteranganmakanan = '" + keteranganmakanan + '\'' + 
			",gambarmakanan = '" + gambarmakanan + '\'' + 
			",namamakanan = '" + namamakanan + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.keteranganmakanan);
		dest.writeString(this.gambarmakanan);
		dest.writeString(this.namamakanan);
	}
	protected MakananResponse(Parcel in) {
		this.keteranganmakanan = in.readString();
		this.gambarmakanan = in.readString();
		this.namamakanan = in.readString();
	}

	public static final Creator<MakananResponse> CREATOR = new Creator<MakananResponse>() {
		@Override
		public MakananResponse createFromParcel(Parcel in) {
			return new MakananResponse(in);
		}

		@Override
		public MakananResponse[] newArray(int size) {
			return new MakananResponse[size];
		}
	};
}