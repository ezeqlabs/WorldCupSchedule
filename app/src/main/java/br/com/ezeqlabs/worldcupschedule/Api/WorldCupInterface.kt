package br.com.ezeqlabs.worldcupschedule.Api

import br.com.ezeqlabs.worldcupschedule.Models.WorldCupInfo
import retrofit2.Call
import retrofit2.http.GET

interface WorldCupInterface {
    @GET("v0/b/world-cup-schedule.appspot.com/o/worldcup.json?alt=media&token=964d2386-e1f2-48dc-aad3-3ab8ac45d591")
    fun getWorldCupInfo() : Call<WorldCupInfo>
}