package com.example.level5gamebacklog.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.util.*

@Parcelize

@Entity(tableName = "gameTable")

data class Game (
    @ColumnInfo(name = "title")
    var tile:String,

    @ColumnInfo(name = "platform")
    var platform: String,


    @ColumnInfo(name = "gameDate")
    var gameDate: Date?,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

): Parcelable