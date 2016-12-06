package ariel.actiongroups.main.common.groups.groups_list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;
import ariel.actiongroups.main.common.utils.GenericViewHolder;

/**
 * Created by home on 7/2/2016.
 */
public class GroupsAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List<GroupRow> dataSet;
    private Context context;

    public GroupsAdapter(Context context, List dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compo_group_row, parent, false);
        return new GroupViewHolder(context, view, dataSet);
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
