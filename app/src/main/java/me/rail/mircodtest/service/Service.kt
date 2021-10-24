package me.rail.mircodtest.service

import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("simpledimple")
    fun getCandidates(): Call<List<Candidate>>
}