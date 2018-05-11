package br.com.ezeqlabs.worldcupschedule.Models

import java.io.Serializable

class WorldCupInfo : Serializable {
    lateinit var groups: List<Group>
}