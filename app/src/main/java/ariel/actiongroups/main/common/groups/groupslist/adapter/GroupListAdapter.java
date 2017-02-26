package ariel.actiongroups.main.common.groups.groupslist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.view.OnActionGroupClicked;
import ariel.actiongroups.main.common.utils.listutils.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

public class GroupListAdapter extends RecyclerView.Adapter<GenericViewHolder> implements GenericRecyclerViewInterface {

    private List<ActionGroup> dataSet;
    private Context context;
    private OnActionGroupClicked onGroupClicked;

    public GroupListAdapter(Context context, List<ActionGroup> dataSet, OnActionGroupClicked onGroupClicked) {
        this.context = context;
        this.dataSet = dataSet;
        this.onGroupClicked = onGroupClicked;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_group_row, parent, false);
        return new GroupRowViewHolder(context, view, dataSet, onGroupClicked);
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

    @Override
    public void refreshAdapter() {
        notifyDataSetChanged();
    }
}
