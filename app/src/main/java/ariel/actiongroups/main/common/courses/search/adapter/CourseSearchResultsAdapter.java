package ariel.actiongroups.main.common.courses.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.OnCourseClicked;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewAdapter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

public class CourseSearchResultsAdapter extends GenericRecyclerViewAdapter implements GenericRecyclerViewInterface {

    private List<Course> dataSet;
    private Context context;
    private OnCourseClicked onCourseClicked;

    public CourseSearchResultsAdapter(Context context, List<Course> dataSet, OnCourseClicked onCourseClicked) {
        super();
        this.dataSet = dataSet;
        this.context = context;
        this.onCourseClicked = onCourseClicked;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_entity_row, parent, false);
        return new CourseSearchViewHolder(context, view, dataSet, onCourseClicked);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(List<Course> dataSet) {
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }
}
