package com.ujjwal.softuserreplica.model

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val name: String?,
    val age: String?,
    val gender: String?,
    val mobileNumber: String?,
    val address: String?,
    val profilePicture: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeString(mobileNumber)
        parcel.writeString(address)
        parcel.writeString(profilePicture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}