package don.com.nbaapp.view

import android.util.Log
import com.ag.printerqoe.base.BaseObserver
import com.ag.printerqoe.base.BasePresenter
import com.google.gson.Gson
import com.google.gson.JsonObject
import don.com.nbaapp.data.mainRepo.MainRepository
import don.com.nbaapp.model.BaseMdl
import don.com.nbaapp.model.BaseMdl.Links
import don.com.nbaapp.model.session.SessionMain
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm

/**
 * Created by gideon on 25,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class MainPresenter(mView: MainView) : BasePresenter<MainView>(mView) {

    var mRequest = MainRepository()

    fun getTodayInfo() {

        mView.showLoading()
        mRequest.getToday()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : BaseObserver<JsonObject>() {
                    override fun onResponseSuccess(result: JsonObject) {
                        mView.stopLoading()
                        Log.wtf("LOG-SUCCESS", result.toString())

                        /*   val realm = Realm.getDefaultInstance()

                           realm.beginTransaction()
                           realm.where(BaseMdl::class.java).findAll().deleteAllFromRealm()
                           realm.commitTransaction()

                           realm.beginTransaction()
                           val gson = Gson()
                           val base = gson.fromJson(result, BaseMdl::class.java!!)
                           realm.insertOrUpdate(base)
                           realm.commitTransaction()





                           val sessionLinks = gson.fromJson(base.links.toString(), Links::class.java)
                           realm.insertOrUpdate(sessionLinks)
                           realm.commitTransaction()*/

                        val realm = Realm.getDefaultInstance()
                        realm.beginTransaction()
                        realm.where(SessionMain::class.java).findAll().deleteAllFromRealm()
                        realm.commitTransaction()


                        val gson = Gson()
                        val base = gson.fromJson(result, BaseMdl::class.java)

                        val sessionMain = realm.where(SessionMain::class.java).findFirst()
                        realm.beginTransaction()
                        if (sessionMain != null) {
                            sessionMain.anchorDate = base.links?.anchorDate!!
                            sessionMain.scoreboard = base.links.scoreboard!!
                            sessionMain.teams = base.links.teams!!
                        }
                        realm.commitTransaction()



//                                mView.onGetTodaySuccess(base.links!!).

                    }

                    override fun onResponseError(errorMessage: String) {
                        mView.stopLoading()
                        mView.errorLoading(errorMessage)
                        Log.wtf("LOG-ERROR", errorMessage)
                    }

                })


    }


}