package ariel.actiongroups.main.common.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by home on 6/28/2016.
 */
public abstract class GenericViewHolder extends RecyclerView.ViewHolder {
    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setUIDataOnView(int position);

}

