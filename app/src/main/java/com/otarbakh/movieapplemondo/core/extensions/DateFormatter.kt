package com.otarbakh.movieapplemondo.core.extensions

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun String.toFormattedDateString(): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy", Locale.getDefault())
        val date = inputFormat.parse(this)
        val calendar = Calendar.getInstance()
        if (date != null) {
            calendar.time = date
        }
        outputFormat.format(calendar.time).replaceFirstChar { it.uppercase() }
    } catch (e: Exception) {
        this
    }
}