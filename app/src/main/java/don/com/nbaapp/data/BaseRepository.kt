package don.com.nbaapp.data

import android.graphics.Bitmap
import don.com.nbaapp.BuildConfig
import don.com.nbaapp.services.ApiClient

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
open class BaseRepository{
    var mApiClient: ApiClient = ApiClient(BuildConfig.BASE_URL)
}