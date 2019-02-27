package don.com.nbaapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import don.com.nbaapp.R
import don.com.nbaapp.helper.GeneralUtil.showToast
import don.com.nbaapp.helper.ROHelper
import don.com.nbaapp.model.BaseMdl.Links
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter
    lateinit var progressDialog: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressDialog = findViewById(R.id.progress_dialog)
        presenter = MainPresenter(this)
        presenter.getTodayInfo()


        btn_scoreboard.setOnClickListener {

            Log.wtf("LOG","TEAMS "+ROHelper.getSessionMain())


        }



    }


    override fun onGetTodaySuccess(links: Links) {

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
