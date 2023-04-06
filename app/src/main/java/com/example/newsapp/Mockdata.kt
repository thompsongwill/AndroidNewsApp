package com.example.newsapp

import android.os.Build
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


object Mockdata {
    val TopNewsList = listOf<NewsData>(
        NewsData(
            1,
            R.drawable.michael,
            author = "Zubby Michael",
            title = "Kelvin violated Covid Protocol by doing maskless indoor press",
            description = "Packers quarterback Kelvin hask Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been cond been conducting in-person interviews withiout mask",
            publishedAt = "2021-11-04T03:21:00z"
        ),

        NewsData(
            2,
            author = "Raja Razek",
            title = "Tiger King, Joe Exotic says he has been diagnosed with agressive Covid 19by doing maskless indoor press",
            description = "Joseph Maldonado, known k Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been condas Joe Exotic on Kelvin has been conducting in-person interviews withiout mask",
            publishedAt = "2021-09-04T03:21:00z"
        ),

        NewsData(
            3,
            R.drawable.jackson,
            author = "Jackson Mike",
            title = "Tiger King, Joe Exotic says he has been diagnosed with agressive Covid 19by doing maskless indoor press",
            description = "Joseph Maldonado,k Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been cond known as Joe Exotic on Kelvin has been conducting in-person interviews withiout mask",
            publishedAt = "2021-09-04T03:21:00z"
        ),
        NewsData(
            4,
            R.drawable.michael,
            author = "Zubby Michael",
            title = "Kelvin violated Covid Protocol by doing maskless indoor press",
            description = "Packers quarterback Kelvin has been Packers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pPackers quarterback Kelvin has been conducting in-pconducting in-person interviews withiout mask",
            publishedAt = "2021-11-04T03:21:00z"
        )
    )


    fun getNews(newsId: Int?): NewsData {
        return TopNewsList.first { it.id == newsId }
    }

    fun Date.getTimeAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.time = this

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val currentCalendar = Calendar.getInstance()
        val currentYear = currentCalendar.get(Calendar.YEAR)
        val currentMonth = currentCalendar.get(Calendar.MONTH)
        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        return if (year < currentYear) {
            val interval = currentYear - year
            if (interval == 1) "$interval year ago" else "$interval years ago"
        } else if (month < currentMonth) {
            val interval = currentMonth - month
            if (interval == 1) "$interval month ago" else "$interval months ago"
        } else if (day < currentDay) {
            val interval = currentDay - day
            if (interval == 1) "$interval day ago" else "$interval days ago"
        } else if (hour < currentHour) {
            val interval = currentHour - hour
            if (interval == 1) "$interval hour ago" else "$interval hours ago"
        }else if (minute < currentMinute){
            val interval = currentMinute - minute
            if(interval==1) "$interval minute ago" else "$interval minutes ago"
        }else{
            "a moment ago"
        }
    }


    fun stringToDate(publishedAt: String): Date{
        val date =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssxx",
                Locale.ENGLISH).parse(publishedAt)
            }else{
                java.text.SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssxx",
                    Locale.ENGLISH).parse(publishedAt))
            }
        Log.d("published", "$date")
        return date
    }

}