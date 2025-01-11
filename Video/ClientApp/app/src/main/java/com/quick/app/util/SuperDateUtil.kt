package com.quick.app.util

import java.util.Calendar

object SuperDateUtil {
    fun currentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    fun currentDayOfMonth(): Int {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }
}