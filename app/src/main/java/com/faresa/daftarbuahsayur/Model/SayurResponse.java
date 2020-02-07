package com.faresa.daftarbuahsayur.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SayurResponse implements Parcelable {

	@SerializedName("keterangansayur")
	private String keterangansayur;

	@SerializedName("namasayur")
	private String namasayur;

	@SerializedName("gambarsayur")
	private String gambarsayur;

	public void setKeterangansayur(String keterangansayur){
		this.keterangansayur = keterangansayur;
	}

	public String getKeterangansayur(){
		return keterangansayur;
	}

	public void setNamasayur(String namasayur){
		this.namasayur = namasayur;
	}

	public String getNamasayur(){
		return namasayur;
	}

	public void setGambarsayur(String gambarsayur){
		this.gambarsayur = gambarsayur;
	}

	public String getGambarsayur(){
		return gambarsayur;
	}

	@Override
 	public String toString(){
		return 
			"SayurResponse{" + 
			"keterangansayur = '" + keterangansayur + '\'' + 
			",namasayur = '" + namasayur + '\'' + 
			",gambarsayur = '" + gambarsayur + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}
	protected SayurResponse(Parcel in) {
		this.keterangansayur = in.readString();
		this.namasayur = in.readString();
		this.gambarsayur = in.readString();
	}

	public static final Creator<SayurResponse> CREATOR = new Creator<SayurResponse>() {
		@Override
		public SayurResponse createFromParcel(Parcel in) {
			return new SayurResponse(in);
		}

		@Override
		public SayurResponse[] newArray(int size) {
			return new SayurResponse[size];
		}
	};
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.keterangansayur);
		dest.writeString(this.namasayur);
		dest.writeString(this.gambarsayur);
	}
}