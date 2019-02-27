package don.com.nbaapp.view

import com.ag.printerqoe.base.BaseView
import don.com.nbaapp.model.BaseMdl.Links

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
interface MainView: BaseView {
    fun onGetTodaySuccess(links: Links)
}