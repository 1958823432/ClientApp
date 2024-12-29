package com.quick.app.util

import java.util.Calendar

object SuperDateUtil {
    fun currentYear() :Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}