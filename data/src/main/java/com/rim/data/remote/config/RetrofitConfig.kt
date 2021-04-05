package com.rim.data.remote.config

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.rim.data.BuildConfig
import com.rim.data.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val IO_TIMEOUT = 30L

fun okHttpBuilder(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .connectTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG)
        client.addNetworkInterceptor(StethoInterceptor())
    return client.build()
}

fun retrofitBuilder(
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
}