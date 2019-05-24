package com.example.kotlinapp3

import android.os.Parcel
import android.os.Parcelable

data class Adress(var city: String, var country: String, val id: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Adress> {
        override fun createFromParcel(parcel: Parcel): Adress {
            return Adress(parcel)
        }

        override fun newArray(size: Int): Array<Adress?> {
            return arrayOfNulls(size)
        }
    }
}


