package com.rim.data.helpers

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class MockServerDispatcher: Dispatcher()  {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return if(request.path == "/films/"){
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(Utils.getJson("getAllMovies.json"))
        }else{
            throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }
}