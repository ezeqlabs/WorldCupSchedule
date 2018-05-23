package br.com.ezeqlabs.worldcupschedule.Utils

import android.content.Context
import br.com.ezeqlabs.worldcupschedule.R
import java.text.SimpleDateFormat
import java.util.*

class TextConverter(context: Context) {
    val context = context

    fun convertCountry(key: String): String {
        val countryName = when (key) {
            "russia" -> context.resources.getString(R.string.russia)
            "saudi_arabia" -> context.resources.getString(R.string.saudi_arabia)
            "egypt" -> context.resources.getString(R.string.egypt)
            "uruguay" -> context.resources.getString(R.string.uruguay)
            "morocco" -> context.resources.getString(R.string.morocco)
            "ir_iran" -> context.resources.getString(R.string.ir_iran)
            "portugal" -> context.resources.getString(R.string.portugal)
            "spain" -> context.resources.getString(R.string.spain)
            "france" -> context.resources.getString(R.string.france)
            "australia" -> context.resources.getString(R.string.australia)
            "argentina" -> context.resources.getString(R.string.argentina)
            "iceland" -> context.resources.getString(R.string.iceland)
            "peru" -> context.resources.getString(R.string.peru)
            "denmark" -> context.resources.getString(R.string.denmark)
            "croatia" -> context.resources.getString(R.string.croatia)
            "nigeria" -> context.resources.getString(R.string.nigeria)
            "costa_rica" -> context.resources.getString(R.string.costa_rica)
            "serbia" -> context.resources.getString(R.string.serbia)
            "germany" -> context.resources.getString(R.string.germany)
            "mexico" -> context.resources.getString(R.string.mexico)
            "brazil" -> context.resources.getString(R.string.brazil)
            "switzerland" -> context.resources.getString(R.string.switzerland)
            "sweden" -> context.resources.getString(R.string.sweden)
            "korea_republic" -> context.resources.getString(R.string.korea_republic)
            "belgium" -> context.resources.getString(R.string.belgium)
            "panama" -> context.resources.getString(R.string.panama)
            "tunisia" -> context.resources.getString(R.string.tunisia)
            "england" -> context.resources.getString(R.string.england)
            "colombia" -> context.resources.getString(R.string.colombia)
            "japan" -> context.resources.getString(R.string.japan)
            "poland" -> context.resources.getString(R.string.poland)
            "senegal" -> context.resources.getString(R.string.senegal)
            else -> key
        }

        return countryName
    }

    fun convertStadium(key: String): String {
        val stadiumName = when (key) {
            "luzhniki_stadium" -> context.resources.getString(R.string.luzhniki_stadium)
            "ekaterinburg_arena" -> context.resources.getString(R.string.ekaterinburg_arena)
            "saint_petersburg_stadium" -> context.resources.getString(R.string.saint_petersburg_stadium)
            "fisht_stadium" -> context.resources.getString(R.string.fisht_stadium)
            "kazan_arena" -> context.resources.getString(R.string.kazan_arena)
            "spartak_stadium" -> context.resources.getString(R.string.spartak_stadium)
            "mordovia_arena" -> context.resources.getString(R.string.mordovia_arena)
            "kaliningrad_stadium" -> context.resources.getString(R.string.kaliningrad_stadium)
            "samara_arena" -> context.resources.getString(R.string.samara_arena)
            "rostov_arena" -> context.resources.getString(R.string.rostov_arena)
            "nizhny_novgorod_stadium" -> context.resources.getString(R.string.nizhny_novgorod_stadium)
            "volgograd_arena" -> context.resources.getString(R.string.volgograd_arena)
            else -> key
        }

        return stadiumName
    }

    fun convertCity(key: String): String {
        val cityName = when (key) {
            "moscow" -> context.resources.getString(R.string.moscow)
            "ekaterinburg" -> context.resources.getString(R.string.ekaterinburg)
            "st_petersburg" -> context.resources.getString(R.string.st_petersburg)
            "sochi" -> context.resources.getString(R.string.sochi)
            "kazan" -> context.resources.getString(R.string.kazan)
            "saransk" -> context.resources.getString(R.string.saransk)
            "kaliningrad" -> context.resources.getString(R.string.kaliningrad)
            "samara" -> context.resources.getString(R.string.samara)
            "rostov_on_don" -> context.resources.getString(R.string.rostov_on_don)
            "nizhny_novgorod" -> context.resources.getString(R.string.nizhny_novgorod)
            "volgograd" -> context.resources.getString(R.string.volgograd)
            else -> key
        }

        return cityName
    }

    fun convertDay(key: String): String {
        val dayName = when (key) {
            "monday" -> context.resources.getString(R.string.monday)
            "tuesday" -> context.resources.getString(R.string.tuesday)
            "wednesday" -> context.resources.getString(R.string.wednesday)
            "thursday" -> context.resources.getString(R.string.thursday)
            "friday" -> context.resources.getString(R.string.friday)
            "saturday" -> context.resources.getString(R.string.saturday)
            "sunday" -> context.resources.getString(R.string.sunday)
            else -> key
        }

        return dayName
    }

    fun convertDate(key: String): String {
        val arr = key.split("-")
        val day = arr[1]
        val month = arr[0]

        val currentLocale = context.resources.configuration.locale

        if (currentLocale.toString().equals("pt_BR")) {
            return "$day/$month"
        }

        return "$month/$day"
    }

    fun convertTime(key: String): String {
        val DATE_FORMAT = "hh:mm a z";
        val formatter = SimpleDateFormat(DATE_FORMAT)

        val date = formatter.parse(key)
        val tz = TimeZone.getDefault()
        formatter.timeZone = tz

        val dateFormatted = formatter.format(date).split(" ")
        val hour = dateFormatted[0]
        val period = dateFormatted[1]
        
        return "$hour $period"
    }

    fun convertLetter(key: String): String {
        val letterName = when (key) {
            "round_of" -> context.resources.getString(R.string.round_of)
            "quarter_finals" -> context.resources.getString(R.string.quarter_finals)
            "semi_finals" -> context.resources.getString(R.string.semi_finals)
            "third_place" -> context.resources.getString(R.string.third_place)
            "finals" -> context.resources.getString(R.string.finals)
            "today" -> context.resources.getString(R.string.today)
            else -> context.resources.getString(R.string.section_format, key)
        }

        return letterName
    }
}