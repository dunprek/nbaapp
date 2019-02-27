package don.com.nbaapp.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by GideonST on 5/24/2018.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);
}