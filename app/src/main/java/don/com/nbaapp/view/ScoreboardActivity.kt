package don.com.nbaapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import don.com.nbaapp.R
import don.com.nbaapp.adapter.SingleAdapter
import don.com.nbaapp.adapter.ViewHolderFactory.ScoresViewHolder
import don.com.nbaapp.helper.GeneralUtil
import don.com.nbaapp.model.BaseMdl.Links
import don.com.nbaapp.model.ScoreBoardMdl.Game
import kotlinx.android.synthetic.main.activity_scoreboard.*

class ScoreboardActivity : AppCompatActivity(),MainView {


    lateinit var presenter: MainPresenter
    var anchorDate = ""
    lateinit var progressDialog: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

        if(intent.extras!=null){
             anchorDate = intent.extras.get("ANCHOR_DATE") as String
        }

        presenter = MainPresenter(this)
        progressDialog = findViewById(R.id.progress_dialog)


        presenter.getScoreboards(anchorDate)





    }



    private fun setAdapter(listGames: List<Game>){
        val myAdapter = object : SingleAdapter<Any>(listGames,this) {
            override fun getLayoutId(position: Int, obj: Any): Int {
                return when(obj){
                    is ScoresViewHolder->R.layout.list_card_team
                    else->R.layout.list_card_team
                }
            }
        }

        rv.layoutManager= LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter=myAdapter
    }

    override fun onGetTodaySuccess(links: Links) {
    }

    override fun onGetScoresSuccess(listGames: List<Game>) {
        Log.wtf("LIST_GAMES",listGames.toString())
        setAdapter(listGames)
    }



    override fun showLoading() {
        progressDialog.visibility = View.VISIBLE
    }

    override fun errorLoading(errorMessage: String?) {

        if (errorMessage != null) {
            GeneralUtil.showToast(this, errorMessage)
        }
        progressDialog.visibility = View.GONE
    }

    override fun stopLoading() {
        progressDialog.visibility = View.GONE
    }
}
