package com.rim.starwars.common

import android.content.Context
import android.util.Log
import com.rim.domain.common.CallErrors
import com.rim.starwars.R

/**
 * Created by Rim Gazzah on 4/4/21.
 **/

fun CallErrors.getErrorMsg(context: Context): String {
    return when (this) {
        is CallErrors.ErrorEmptyData -> context.getString(R.string.error_empty_data)
        is CallErrors.ErrorException -> {
            Log.e(STAR_WARS_LOG, "Operation Error message: ${throwable.message}")
            context.getString(R.string.error_operation)
        }
        else -> context.getString(R.string.error_data)
    }
}