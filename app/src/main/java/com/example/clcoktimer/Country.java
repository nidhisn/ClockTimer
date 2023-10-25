package com.example.clcoktimer;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Country  implements Parcelable {
    String name;

    int timeDifference;

    public Country(String name, int timeDifference){
        this.name = name;
        this.timeDifference = timeDifference;
    }

    protected Country(Parcel in) {
        name = in.readString();
        timeDifference = in.readInt();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(timeDifference);
    }
}
