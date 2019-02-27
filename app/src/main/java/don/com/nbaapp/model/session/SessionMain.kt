package don.com.nbaapp.model.session

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by gideon on 27,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */


open class SessionMain : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var anchorDate: String =""
    var teams: String =""
    var scoreboards: String =""




}