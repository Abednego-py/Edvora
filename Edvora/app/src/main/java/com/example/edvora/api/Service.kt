package com.example.edvora.api

import retrofit2.http.GET

interface Service {
    @GET("/rides")
    suspend fun ListRides() : Rides
}