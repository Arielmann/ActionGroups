package ariel.actiongroups.main.common.courses.manager.coursedetails.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.manager.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.common.groups.groupslist.adapter.GroupRowViewHolder;
import ariel.actiongroups.main.common.groups.groupslist.view.GroupListViewInterface;
import ariel.actiongroups.main.common.utils.abstractutils.GenericViewHolder;

public class CourseDetailsAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List dataSet;
    private Context context;
    private GroupListViewInterface onGroupClicked;

    public CourseDetailsAdapter(Context context, GroupListViewInterface onGroupClicked) {
        this.context = context;
        this.dataSet = CourseDetailsModel.getInstance().getGroups();
        this.onGroupClicked = onGroupClicked;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compo_group_row, parent, false);
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
}
