package ariel.actiongroups.main.common.utils.abstractions;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericViewHolder extends RecyclerView.ViewHolder {
    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setUIDataOnView(int position);

}

