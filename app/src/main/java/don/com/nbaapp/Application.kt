package don.com.nbaapp

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by gideon on 26,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class Application : Application() {


    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .build())
    }
}