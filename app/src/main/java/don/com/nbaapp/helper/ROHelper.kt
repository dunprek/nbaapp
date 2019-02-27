package don.com.nbaapp.helper

import android.se.omapi.Session
import don.com.nbaapp.model.session.SessionMain
import io.realm.Realm

/**
 * Created by gideon on 27,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object ROHelper {


    fun getSessionMain():String {

        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val sessionProfile = realm.where(SessionMain::class.java).findFirst()
        val userId = sessionProfile!!.scoreboard
        realm.commitTransaction()

        return userId
    }


}