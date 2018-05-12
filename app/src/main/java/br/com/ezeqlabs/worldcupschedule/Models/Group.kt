package br.com.ezeqlabs.worldcupschedule.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Group : Serializable {
    lateinit var letter: String
    @SerializedName("group_info")
    lateinit var teams: List<Team>
    lateinit var games: List<Game>
}