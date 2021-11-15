package com.example.utilsmodule.utils

import java.time.Instant

import java.util.concurrent.TimeUnit


object UsersDateUtils {

    private fun dateTZToEpochInMilliSec(dateTZ: String): Long {
        return Instant.parse(dateTZ).toEpochMilli()
    }

    fun ageInMilliSec(dateTZ: String): Long {
        return System.currentTimeMillis() - dateTZToEpochInMilliSec(dateTZ)
    }

    fun countDownForNextBD(ageInMillis: Long): Int {
        val millisPerYear = TimeUnit.DAYS.toMillis(365)
        val nextBDInMillis = ageInMillis.mod(millisPerYear)
        val nextBDInDays = 365 - nextBDInMillis.div(TimeUnit.DAYS.toMillis(1)).toInt()
        return nextBDInDays
    }
}