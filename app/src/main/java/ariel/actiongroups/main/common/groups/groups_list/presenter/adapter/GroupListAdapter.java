package ariel.actiongroups.main.common.groups.groups_list.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.abstractions.GenericViewHolder;

public class GroupListAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List dataSet;
    private Context context;

    public GroupListAdapter(Context context, List dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compo_group_row, parent, false);
        return new GroupRowViewHolder(context, view, dataSet);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
