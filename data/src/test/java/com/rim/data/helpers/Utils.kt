package com.rim.data.helpers

import com.google.common.io.Resources.getResource
import com.rim.data.remote.ApiServices
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by Rim Gazzah on 4/5/21.
 **/

object Utils{
    internal fun getJson(path: String): String {
        val uri = getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
    fun okHttpBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    fun retrofitBuilder(okHttpClient: OkHttpClient, mockWebServer: MockWebServer): ApiServices {
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}
