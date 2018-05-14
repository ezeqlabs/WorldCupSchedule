package br.com.ezeqlabs.worldcupschedule.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class WorldCupInfo : Serializable {
    lateinit var groups: List<Group>
    @SerializedName("knockout_phase")
    lateinit var knockoutPhase: List<Group>
    lateinit var phase: String
}