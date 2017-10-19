package ariel.actiongroups.main.leader.courses.creator.singlecourse.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.coursedetails.view.CourseDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;

class CourseDesignerFooter extends GenericViewHolder {
    private static final String TAG = CourseDesignerFooter.class.getSimpleName();

    CourseDesignerFooter(Context context, View footer) {
        super(footer);
        Button addChallenge = (Button) footer.findViewById(R.id.addChallenge);
        Button saveCourse = (Button) footer.findViewById(R.id.saveCourse);
        ActivityStarter.setStartActivityOnClickListener(addChallenge, context, ChallengeEditorActivity.class);
        ActivityStarter.setStartActivityOnClickListener(saveCourse, context, CourseDetailsActivity.class);
    }

    @Override
    public void setUIDataOnView(int position) {
        Log.d(TAG, "Course manager footer UI created and set");
    }
}
