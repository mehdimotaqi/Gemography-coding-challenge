package com.gemography.coding.challenge.di

import com.gemography.coding.challenge.data.network.GithubApi
import com.gemography.coding.challenge.data.network.NetworkConstant
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.sin

val networkModule = module {


    single {
        GsonConverterFactory.create()
    }

    single {
        OkHttpClient().newBuilder()
            .connectTimeout(NetworkConstant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConstant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkConstant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(NetworkConstant.NETWORK_BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(GithubApi::class.java)
    }
}