package com.example.notesapp.Model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Notes")
@Parcelize
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String?,
    var subTitle: String,
    var notes: String,
    var date: String,
    var priority:String
):Parcelable