package com.example.traninghttp

import android.content.Context
import android.content.Intent
import com.example.traninghttp.room.WeatherDao
import com.example.traninghttp.room.WeatherDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import java.sql.DriverManager
import java.sql.DriverManager.println


class ConnectManager() {
    var json: JSONObject = JSONObject()

    var client = OkHttpClient()

    fun getApi(): JSONObject {
        val request = Request.Builder()
            .url("https://weather.tsukumijima.net/api/forecast?city=400040")
            .build()

        client.newCall(request).execute().use { response ->

            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            json = JSONObject(response.body?.string())

        }
        return json
    }
}