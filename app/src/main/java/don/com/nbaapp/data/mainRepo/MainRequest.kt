package don.com.nbaapp.data.mainRepo

import com.google.gson.JsonObject
import io.reactivex.Observable

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
interface MainRequest {
    fun getToday():Observable<JsonObject>
    fun getScoreboards(gameDate:String):Observable<JsonObject>
}