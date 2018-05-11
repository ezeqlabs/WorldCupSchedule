package br.com.ezeqlabs.worldcupschedule.Models

import java.io.Serializable

class Group : Serializable {
    lateinit var letter: String
    lateinit var games: List<Game>
}