package ariel.actiongroups.main.common.utils.listutils.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericRecyclerViewAdapter extends RecyclerView.Adapter<GenericViewHolder> implements GenericRecyclerViewInterface {

    protected GenericRecyclerViewAdapter() {
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position);
    }

    @Override
    public void refreshAdapter() {
        notifyDataSetChanged();
    }

}
