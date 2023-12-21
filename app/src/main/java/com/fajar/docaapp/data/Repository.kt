package com.fajar.docaapp.data

import androidx.lifecycle.liveData
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import retrofit2.HttpException

class Repository(
    private val apiService: ApiService
) {
    suspend fun getNearbyPetShop(latLng: LatLng) = liveData {
        emit(Result.Loading)
        val location = "${latLng.latitude},${latLng.longitude}"
        try {
            val successResponse = apiService.getNearbyPetShop(location = location).results
            emit(Result.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, Response::class.java)
            emit(Result.Error(errorResponse.status.toString()))
        }
    }

    suspend fun getNearbyPetVet(latLng: LatLng) = liveData {
        emit(Result.Loading)
        val location = "${latLng.latitude},${latLng.longitude}"
        try {
            val successResponse = apiService.getNearbyPetVet(location = location).results
            emit(Result.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, Response::class.java)
            emit(Result.Error(errorResponse.status.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(apiService)
            }.also { instance = it }
    }
}