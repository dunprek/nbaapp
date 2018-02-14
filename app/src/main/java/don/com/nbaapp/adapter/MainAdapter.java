package don.com.nbaapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gideon on 14/02/18.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {

            super(itemView);


        }
    }
}
