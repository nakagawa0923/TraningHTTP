package com.example.traninghttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traninghttp.room.WeatherDatabase
import com.example.traninghttp.room.WeatherEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val list = getAll()
        }
    }
    suspend fun getAll():List<WeatherEntity>{
        LaunchActivity.db = WeatherDatabase.getDatabase(applicationContext)
        val dao = LaunchActivity.db.weatherDao()
        val list = dao.getAll()
        return list
    }
}


