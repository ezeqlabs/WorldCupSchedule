package br.com.ezeqlabs.worldcupschedule.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Team : Serializable {
    @SerializedName("team")
    lateinit var name : String
    @SerializedName("matches_played")
    val matchesPlayed : Int = 4
    val wins : Int = 4
    val loses : Int = 4
    val points : Int = 4
    val position : Int = 4
}