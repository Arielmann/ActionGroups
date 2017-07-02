package ariel.actiongroups.main.common.courses.search.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.OnCourseClicked;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;
import ariel.actiongroups.main.common.utils.listutils.vh.EntityViewHolder;

public class CourseSearchViewHolder extends EntityViewHolder implements View.OnClickListener {

    private static final String TAG = CourseSearchViewHolder.class.getSimpleName();

    private final OnCourseClicked onCourseClicked;
    private final List<Course> dataSet;

    CourseSearchViewHolder(Context context, View itemView, List<Course> dataSet, OnCourseClicked onCourseClicked) {
        super(context, itemView);
        this.dataSet = dataSet;
        this.onCourseClicked = onCourseClicked;
    }

    public void setUIDataOnView(int position) {
        final String imagePath = dataSet.get(position).getImageUrl();
        final String description = dataSet.get(position).getDescription();
        final String name = dataSet.get(position).getName();

        if (imagePath != null && description != null && name != null) {
            setDataOnEntityViews(name, description, ImageUtils.defaultProfileImage);
        }
    }

    @Override
    public void onClick(View view) {
        int position = this.getLayoutPosition();
        onCourseClicked.onCourseClicked(dataSet.get(position));
    }
}

