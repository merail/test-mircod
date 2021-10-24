package me.rail.mircodtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.rail.mircodtest.service.Candidate
import me.rail.mircodtest.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = ServiceBuilder.build()

        service.getCandidates().enqueue(object : Callback<List<Candidate>> {
            override fun onResponse(
                call: Call<List<Candidate>>,
                response: Response<List<Candidate>>
            ) {
                val candidates = response.body()
            }

            override fun onFailure(call: Call<List<Candidate>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}