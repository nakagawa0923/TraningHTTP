package com.example.traninghttp.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

@Dao

interface WeatherDao {
    @Query("SELECT * FROM whether")
    fun getAll(): List<WeatherEntity>

    @Insert
    fun insert(data : WeatherEntity)

    @Update
    fun update(data: WeatherEntity)

    @Delete
    fun delete(data: WeatherEntity): Int
}