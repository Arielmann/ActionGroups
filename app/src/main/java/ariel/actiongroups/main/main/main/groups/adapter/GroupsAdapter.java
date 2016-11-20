package ariel.actiongroups.main.main.main.groups.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.groups.model.GroupRow;
import ariel.actiongroups.main.main.main.utils.GenericViewHolder;

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
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_conversation_row, parent, false);
        return new GroupViewHolder(context, view, dataSet);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        holder.setUIDataOnView(position);
        OnContactedUserClicked onConversationClicked = new OnContactedUserClicked(context, new String[]{dataSet.get(position).getAddressedUserName()});
        holder.setCustomClickListener(holder.itemView, onConversationClicked);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public List<GroupRow> getDataSet() {
        return dataSet;
    }
}
