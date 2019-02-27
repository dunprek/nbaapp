package don.com.nbaapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import don.com.nbaapp.R
import don.com.nbaapp.helper.GeneralUtil
import don.com.nbaapp.model.ScoreBoardMdl.Game
import don.com.nbaapp.view.MainActivity

/**
 * Created by gideon on 21,December,2018
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */


object ViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.list_card_team -> ScoresViewHolder(view)
//            R.layout.item_list_user_detail -> OtherViewHolder(view)
            else -> {
                ScoresViewHolder(view)
            }
        }
    }


    class ScoresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SingleAdapter.Binder<Game> {

        var tvName: TextView = itemView.findViewById(R.id.tv_team_name)
        var tvCity: TextView = itemView.findViewById(R.id.tv_team_city)

        override fun bind(data: Game, context: Context) {
            tvName.text = data.vTeam.toString()
            tvCity.text = data.arena!!.name
            tvName.setOnClickListener {
                if (context is MainActivity) {
                    GeneralUtil.showToast(context, " " + adapterPosition)
                }
            }
        }



    }

    /*  class OtherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), MainAdapter.Binder<OtherMdl> {
          override fun bind(data: OtherMdl, context: Context) {
              tvName.text = data.name
              tvAddress.text = data.address
              llContainer.setOnClickListener {
                  (context as MainActivity).showToast(adapterPosition)
              }
          }

          var tvName: TextView = itemView.findViewById(R.id.tv_name)
          var tvAddress: TextView = itemView.findViewById(R.id.tv_address)
          var llContainer: LinearLayout = itemView.findViewById(R.id.ll_container)

      }*/


}