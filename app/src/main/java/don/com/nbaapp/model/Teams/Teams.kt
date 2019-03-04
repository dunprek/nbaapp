package don.com.nbaapp.model.Teams

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by gideon on 28,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
@Entity(tableName = "teams")
data class Teams(@PrimaryKey(autoGenerate = true) val id: Long,
                         @ColumnInfo(name = "isNBAFranchise") val isNBAFranchise: Boolean,
                         @ColumnInfo(name = "isAllStar") val isAllStar: Boolean,
                         @ColumnInfo(name = "city") val city: String,
                         @ColumnInfo(name = "altCityName") val altCityName: String,
                         @ColumnInfo(name = "fullName") val fullName: String,
                         @ColumnInfo(name = "tricode") val tricode: String,
                         @ColumnInfo(name = "teamId") val teamId: String,
                         @ColumnInfo(name = "nickname") val nickname: String,
                         @ColumnInfo(name = "urlName") val urlName: String,
                         @ColumnInfo(name = "confName") val confName: String,
                         @ColumnInfo(name = "divName") val divName: String)


