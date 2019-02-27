package don.com.nbaapp.data.mainRepo

import com.google.gson.JsonObject
import don.com.nbaapp.data.BaseRepository
import io.reactivex.Observable

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class MainRepository : BaseRepository(), MainRequest {
    override fun getScoreboards(gameDate: String): Observable<JsonObject> {
        return mApiClient.mApiServices.getScoreBoards(gameDate).flatMap { Observable.just(it) }
    }

    override fun getToday(): Observable<JsonObject> {
        return mApiClient.mApiServices.getToday().flatMap { Observable.just(it) }
    }

}