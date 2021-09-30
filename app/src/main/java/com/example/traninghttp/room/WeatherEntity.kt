package com.example.traninghttp.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject
import java.util.*

@Entity(tableName = "whether")
class WeatherEntity(
    var TodayDateLabel:String?,
    var TodayTelop:String?,
    var tomorrowDateLabel:String?,
    var tomorrowTelop:String?,
    var DayAfterDateLabel:String?,
    var DayAfterTelop:String?
    ){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0}