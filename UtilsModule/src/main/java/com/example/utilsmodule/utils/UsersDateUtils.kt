package com.example.utilsmodule.utils

import java.time.Instant


object UsersDateUtils {

    private fun dateTZToEpochInMilliSec(dateTZ: String): Long {
        return Instant.parse(dateTZ).toEpochMilli()
    }

    fun ageInMilliSec(dateTZ: String): Long {
        return System.currentTimeMillis() - dateTZToEpochInMilliSec(dateTZ)
    }

//    private fun nextBirthdayToEpochInMilliSec(dateTZ: String): Long {
//        val timeOfBirthInMillis =  Instant.parse(dateTZ).toEpochMilli()
//        val nextYearTodayInMillis = System.currentTimeMillis() + 52 * DateUtils.WEEK_IN_MILLIS
//        val millisToBirthday =
//    }

}