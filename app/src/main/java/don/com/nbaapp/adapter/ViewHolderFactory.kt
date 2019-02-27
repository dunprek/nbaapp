package don.com.nbaapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import don.com.nbaapp.model.BaseMdl.Links

/**
 * Created by gideon on 21,December,2018
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */


object ViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
           android.R.layout.simple_list_item_1 -> NameViewHolder(view)
//            R.layout.item_list_user_detail -> OtherViewHolder(view)
            else -> {
                NameViewHolder(view)
            }
        }
    }


    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SingleAdapter.Binder<Links> {
        override fun bind(data: Links, context: Context) {
//            textView.text = data.;
/*            textView.setOnClickListener {
//                (context as MainActivity).showToast(adapterPosition)

                if(context is MainActivity){
                    GeneralUtil.showToast(context," "+adapterPosition)
                }
            }*/
        }

//        var textView: TextView = itemView.findViewById(R.id.tv_name)

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