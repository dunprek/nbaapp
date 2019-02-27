package don.com.nbaapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration

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


        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(config)

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build())
    }
}