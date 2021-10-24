package me.rail.mircodtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.rail.mircodtest.databinding.ActivityMainBinding
import me.rail.mircodtest.service.Candidate
import me.rail.mircodtest.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val service = ServiceBuilder.build()

        service.getCandidates().enqueue(object : Callback<List<Candidate>> {
            override fun onResponse(
                call: Call<List<Candidate>>,
                response: Response<List<Candidate>>
            ) {
                val candidates = response.body()

                if (candidates != null) {
                    binding?.recyclerview?.layoutManager =
                        LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                    binding?.recyclerview?.adapter = Adapter(applicationContext, candidates)
                }
            }

            override fun onFailure(call: Call<List<Candidate>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}