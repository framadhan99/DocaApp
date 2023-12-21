package com.fajar.docaapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("json")
    suspend fun getNearbyPetShop(
        @Query("type") type: String = "pet_store",
        @Query("location") location: String,
        @Query("radius") radius: String = "5000",
        @Query("key") key: String = "AIzaSyBabwY_Yq6YhjYZnuqw19_LT0jXA6rVXmg",
    ): Response

    @GET("json")
    suspend fun getNearbyPetVet(
        @Query("type") type: String = "veterinary_care",
        @Query("location") location: String,
        @Query("radius") radius: String = "5000",
        @Query("key") key: String = "AIzaSyBabwY_Yq6YhjYZnuqw19_LT0jXA6rVXmg",
    ): Response
}