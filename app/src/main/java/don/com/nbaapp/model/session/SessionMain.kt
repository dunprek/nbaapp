package don.com.nbaapp.model.session

import io.realm.RealmObject

/**
 * Created by gideon on 27,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
open class SessionMain:RealmObject() {
    var anchorDate =""
    var scoreboard =""
    var teams =""
    override fun toString(): String {
        return "SessionMain(anchorDate='$anchorDate', scoreboard='$scoreboard', teams='$teams')"
    }
}