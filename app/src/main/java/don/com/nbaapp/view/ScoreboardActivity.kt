package don.com.nbaapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import don.com.nbaapp.R
import don.com.nbaapp.model.BaseMdl.Links
import don.com.nbaapp.model.ScoreBoardMdl.Game

class ScoreboardActivity : AppCompatActivity(),MainView {


    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard)

        val anchorDate:String = intent.extras.get("ANCHOR_DATE") as String

        presenter = MainPresenter(this)


        presenter.getScoreboards(anchorDate)

    }


    override fun onGetTodaySuccess(links: Links) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetScoresSuccess(listGames: List<Game>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun errorLoading(errorMessage: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
