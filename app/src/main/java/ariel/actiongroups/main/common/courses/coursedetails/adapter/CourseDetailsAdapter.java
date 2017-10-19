package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.headerrecyclerview.HeaderRecyclerViewAdapter;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.ListPresentable;
import ariel.actiongroups.main.common.utils.listutils.vh.OnAddEntityVHClicked;
import ariel.actiongroups.main.common.groups.groupslist.adapter.GroupRowViewHolder;
import ariel.actiongroups.main.common.groups.groupslist.view.OnActionGroupClicked;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

public class CourseDetailsAdapter extends HeaderRecyclerViewAdapter<GenericViewHolder, Course, ActionGroup, CourseDetailsHeader> implements GenericRecyclerViewInterface{

    private List<ActionGroup> dataSet;
    private Context context;
    private OnActionGroupClicked onGroupClicked;
    private OnAddEntityVHClicked onAddGroupVHClicked;

    public CourseDetailsAdapter(Context context, List<ActionGroup> dataSet, OnAddEntityVHClicked onAddGroupVHClicked, OnActionGroupClicked onGroupClicked) {
        this.context = context;
        this.dataSet = dataSet;
        this.onGroupClicked = onGroupClicked;
        this.onAddGroupVHClicked = onAddGroupVHClicked;
    }

    @Override
    protected GenericViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        final View headerView = getLayoutInflater(parent).inflate(R.layout.header_course_details, parent, false);
        return new CourseDetailsHeader(headerView, getHeader(), onAddGroupVHClicked);
    }

    @Override
    public GenericViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        final View view = getLayoutInflater(parent).inflate(R.layout.vh_entity_row, parent, false);
        return new GroupRowViewHolder(context, view, dataSet, onGroupClicked);
    }

    @Override
    public void onBindItemViewHolder(GenericViewHolder holder, int position) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position - 1); //-1 for header
    }

    @Override
    protected void onBindHeaderViewHolder(GenericViewHolder holder, int position) {
        holder.setUIDataOnView(0);
    }

    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }

    @Override
    public void refreshAdapter() {
        notifyDataSetChanged();
    }
}

