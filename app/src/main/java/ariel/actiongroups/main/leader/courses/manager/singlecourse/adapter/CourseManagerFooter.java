package ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.coursedetails.view.CourseDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.challenges.creator.view.CreateChallengeActivity;

class CourseManagerFooter extends GenericViewHolder {
    private static final String TAG = CourseManagerFooter.class.getSimpleName();

    CourseManagerFooter(Context context, View footer) {
        super(footer);
        Button addChallenge = (Button) footer.findViewById(R.id.addChallenge);
        Button saveCourse = (Button) footer.findViewById(R.id.saveCourse);
        ActivityStarter.setStartActivityOnClickListener(addChallenge, context, CreateChallengeActivity.class);
        ActivityStarter.setStartActivityOnClickListener(saveCourse, context, CourseDetailsActivity.class);
    }

    @Override
    public void setUIDataOnView(int position) {
        Log.d(TAG, "Course manager footer UI created and set");
    }
}
