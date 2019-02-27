package don.com.nbaapp

import android.app.Application
import com.facebook.stetho.Stetho
import io.realm.Realm

/**
 * Created by gideon on 26,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class Application : Application() {


    override fun onCreate() {
        super.onCreate()
        Realm.init(this) //init realmdb this covers all use of realm    within the project.
        Stetho.initializeWithDefaults(this)
    }
}