package com.rim.data.remote.common

import com.rim.domain.common.CallErrors
import com.rim.domain.common.CallResult
import retrofit2.Response

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
inline fun <reified T, X> Response<T>.getResult(applyOperation: T.() -> X): CallResult<X> {
    if (this.isSuccessful) {
        if (this.body() == null) {
            return CallResult.Error(CallErrors.ErrorEmptyData)
        } else {
            if (this.body() is T) {
                return CallResult.Success((this.body() as T).applyOperation())
            }
        }
    }
    return CallResult.Error(CallErrors.ErrorServer)
}