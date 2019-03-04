package don.com.nbaapp.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import don.com.nbaapp.R
import don.com.nbaapp.helper.GeneralUtil.showToast
import don.com.nbaapp.model.BaseMdl.Links
import don.com.nbaapp.model.ScoreBoardMdl.Game
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {


    lateinit var presenter: MainPresenter
    lateinit var progressDialog: LinearLayout


    var anchorDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressDialog = findViewById(R.id.progress_dialog)
        presenter = MainPresenter(this)
        presenter.getTodayInfo()


        btn_scoreboard.setOnClickListener {

//            Log.wtf("LOG","TEAMS "+ROHelper.getSessionMain())



       /*     Gson gson = new Gson();
            Type listType = new TypeToken<List<DataListDistrict>>() {
            }.getType();
            List<DataListDistrict> list = (List<DataListDistrict>) gson.fromJson(String.valueOf(data), listType);

            realm.beginTransaction();
            realm.insertOrUpdate(list);

            int users_id = realm.where(SessionProfile.class).findFirst().getUserId();
            int district_id = realm.where(SessionProfile.class).equalTo("id", users_id).findFirst().getDistrict_id();
            for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDistrict_id() == district_id){
                sessionProfile.setDistrict_name(list.get(i).getDistrict_name());
            }
        }
            realm.commitTransaction();*/



          /*  realm.beginTransaction();
            LocalSetting setting = realm.where(LocalSetting.class).findFirst();
            setting.setFromUpdate(fromUpdateProfile);
            realm.commitTransaction();*/

            val intent = Intent(this,ScoreboardActivity::class.java)
            intent.putExtra("ANCHOR_DATE",anchorDate)
            startActivity(intent)

        }



    }


    override fun onGetTodaySuccess(links: Links) {

        Log.wtf("NOTIF","SUKSES")
        Log.wtf("onGetTodaySuccess",links.toString())
/*
        realm.beginTransaction()
        val sessionMain = realm.where(SessionMain::class.java).findFirst()
        if (sessionMain != null) {
            sessionMain.anchorDate = links.anchorDate!!
            sessionMain.teams = links.teams!!
        }

        realm.commitTransaction()

        if (sessionMain != null) {
            Log.wtf("SESSION_MAIN",sessionMain.teams)
        }*/

//        presenter.getScoreboards(links.anchorDate!!)

        anchorDate = links.anchorDate!!



    }

    override fun onGetScoresSuccess(listGames: List<Game>) {
        Log.wtf("onGetScoresSuccess",listGames.toString())
    }

    override fun showLoading() {
        progressDialog.visibility = View.VISIBLE
    }

    override fun errorLoading(errorMessage: String?) {

        if (errorMessage != null) {
            showToast(this, errorMessage)
        }
        progressDialog.visibility = View.GONE
    }

    override fun stopLoading() {
        progressDialog.visibility = View.GONE
    }

}
