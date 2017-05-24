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
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewAdapter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

public class GroupListAdapter extends GenericRecyclerViewAdapter implements GenericRecyclerViewInterface {

    private List<ActionGroup> dataSet;
    private Context context;
    private OnActionGroupClicked onGroupClicked;

    public GroupListAdapter(Context context, List<ActionGroup> dataSet, OnActionGroupClicked onGroupClicked) {
        super();
        this.dataSet = dataSet;
        this.context = context;
        this.onGroupClicked = onGroupClicked;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_entity_row, parent, false);
        return new GroupRowViewHolder(context, view, dataSet, onGroupClicked);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
