package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
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
        switch (viewType) {
            case 100:
                final View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_group_row, parent, false);
                return new GroupRowViewHolder(context, headerView, dataSet, onGroupClicked);

            case 101:
                final View silenceView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_silence_notifications_with_switch, parent, false);
                return new SilenceEntityWithSwitchVH(context, silenceView, CourseDetailsModel.getInstance().getCourse());

            default:
                final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_group_row, parent, false);
                return new GroupRowViewHolder(context, view, dataSet, onGroupClicked);
        }
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        if(holder instanceof View.OnClickListener) {
            holder.itemView.setOnClickListener((View.OnClickListener) holder);
        }
        holder.setUIDataOnView(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position + 100;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
