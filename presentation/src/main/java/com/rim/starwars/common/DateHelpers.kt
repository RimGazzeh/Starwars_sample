package com.rim.starwars.common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
const val DATE_SIMPLE_INPUT_TEMPLATE = "yyyy-MM-dd"
const val DATE_FULL_DATE_INPUT_TEMPLATE = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"
const val DATE_OUTPUT_TEMPLATE = "yyyy/MM/dd"

object DateHelpers {

    fun releaseDateFormat(movieDate: String): String? {
        return formatDate(DATE_SIMPLE_INPUT_TEMPLATE, DATE_OUTPUT_TEMPLATE, movieDate)
    }

    fun movieEditDateFormat(date: String): String? {
        return formatDate(DATE_FULL_DATE_INPUT_TEMPLATE, DATE_OUTPUT_TEMPLATE, date)
    }

    private fun formatDate(
        inputTemplate: String,
        outputTemplate: String,
        dateString: String
    ): String? {
        val dfInput = getDateFormat(inputTemplate)
        val dfOutput = getDateFormat(outputTemplate)
        try {
            dfInput.parse(dateString)?.let { return dfOutput.format(it) }
                ?: kotlin.run { return null }
        } catch (e: Exception) {
            return null
        }
    }

    private fun getDateFormat(dateTemplate: String): SimpleDateFormat {
        return SimpleDateFormat(dateTemplate, Locale.getDefault())
    }
}
