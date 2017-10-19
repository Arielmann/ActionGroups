package ariel.actiongroups.main.leader.courses.creator.singlecourse.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;

class CourseDesignerHeader extends GenericViewHolder {

    private static final String TAG = CourseDesignerHeader.class.getSimpleName();
    private final View layout;
    private String titleText;

    CourseDesignerHeader(View headerLayout, String titleText) {
        super(headerLayout);
        this.layout = headerLayout;
        this.titleText = titleText;
        Log.d(TAG, "Course header created");
    }

    @Override
    public void setUIDataOnView(int position) {
        TextView simpleTitleTV = (TextView) layout.findViewById(R.id.simpleTitleTV);
        simpleTitleTV.setText(titleText);
        Log.d(TAG, "Course header text: " + simpleTitleTV.getText());
    }
}
