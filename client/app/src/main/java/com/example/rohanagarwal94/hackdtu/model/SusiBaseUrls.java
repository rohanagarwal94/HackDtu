package com.example.rohanagarwal94.hackdtu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajan Maurya on 12/10/16.
 */

public class SusiBaseUrls implements Parcelable {

    @SerializedName("susi_service")
    private List<String> susiServices = new ArrayList<>();

    public List<String> getSusiServices() {
        return susiServices;
    }

    public void setSusiServices(List<String> susiServices) {
        this.susiServices = susiServices;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.susiServices);
    }

    public SusiBaseUrls() {
    }

    protected SusiBaseUrls(Parcel in) {
        this.susiServices = in.createStringArrayList();
    }

    public static final Creator<SusiBaseUrls> CREATOR =
            new Creator<SusiBaseUrls>() {
                @Override
                public SusiBaseUrls createFromParcel(Parcel source) {
                    return new SusiBaseUrls(source);
                }

                @Override
                public SusiBaseUrls[] newArray(int size) {
                    return new SusiBaseUrls[size];
                }
            };
}
