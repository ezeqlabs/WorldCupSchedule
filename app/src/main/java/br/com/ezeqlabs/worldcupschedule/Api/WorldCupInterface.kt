package br.com.ezeqlabs.worldcupschedule.Api

import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import retrofit2.Call
import retrofit2.http.GET

interface WorldCupInterface {
    @GET("v0/b/world-cup-schedule.appspot.com/o/worldcup_winners.json?alt=media&token=c86123f4-4d02-4226-bd3b-1c0a86f2fce9")
    fun getWorldCupInfo() : Call<WorldCupInfo>
}