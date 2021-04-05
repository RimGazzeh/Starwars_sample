package com.rim.data.base

import com.rim.data.helpers.MockServerDispatcher
import com.rim.data.helpers.Utils
import com.rim.data.remote.ApiServices
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
open class MockServerTest {
    private lateinit var mMockWebServer: MockWebServer

    lateinit var mApiServices: ApiServices

    private lateinit var mOkHttpClient: OkHttpClient

    private fun initMockServer() {
        mMockWebServer = MockWebServer()
        mMockWebServer.dispatcher = MockServerDispatcher()
        mMockWebServer.start()
    }

    @Before
    open fun startMockServer() {
        initMockServer()
        mOkHttpClient = Utils.okHttpBuilder()
        mApiServices = Utils.retrofitBuilder(mOkHttpClient, mMockWebServer)
    }

    @After
    open fun stopMockServer() {
        mMockWebServer.shutdown()
    }
}