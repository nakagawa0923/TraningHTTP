package com.example.traninghttp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.traninghttp.room.WeatherDatabase
import com.example.traninghttp.room.WeatherEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LaunchActivity : AppCompatActivity(){

    companion object {
        lateinit var db: WeatherDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch)
        GlobalScope.launch {
                insert()
        }
    }

    suspend fun insert() {
        db = WeatherDatabase.getDatabase(applicationContext)
        val dao = db.weatherDao()
        val responsObj = ConnectManager().getApi()
        val newEntity = WeatherEntity(
            responsObj.getJSONArray("forecasts").getJSONObject(0).getString("dateLabel"),
            responsObj.getJSONArray("forecasts").getJSONObject(0).getString("telop"),
            responsObj.getJSONArray("forecasts").getJSONObject(1).getString("dateLabel"),
            responsObj.getJSONArray("forecasts").getJSONObject(1).getString("telop"),
            responsObj.getJSONArray("forecasts").getJSONObject(2).getString("dateLabel"),
            responsObj.getJSONArray("forecasts").getJSONObject(2).getString("telop"))
        dao.insert(newEntity)
    }

}