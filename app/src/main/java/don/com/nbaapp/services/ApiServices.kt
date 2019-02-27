package don.com.nbaapp.services

import com.google.gson.JsonObject
import don.com.nbaapp.model.BaseMdl.Links
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
interface ApiServices {

    @GET("prod/v3/today.json")
    fun getToday(): Observable<JsonObject>

    @GET("prod/v2/{gameDate}/scoreboard.json")
    fun getScoreBoards(@Path("gameDate") gameDate: String):Observable<JsonObject>






}