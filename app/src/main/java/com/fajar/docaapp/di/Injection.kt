package com.fajar.docaapp.di

import android.content.Context
import com.fajar.docaapp.data.ApiConfig
import com.fajar.docaapp.data.Repository

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}