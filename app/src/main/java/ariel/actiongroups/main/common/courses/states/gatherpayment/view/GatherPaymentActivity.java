package ariel.actiongroups.main.common.courses.states.gatherpayment.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGatherPaymentBinding;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class GatherPaymentActivity extends AppCompatActivity {

    Course course;
    ActionGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGatherPaymentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gather_payment);
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        binding.startCourse.setOnClickListener(startCourse);
    }

    View.OnClickListener startCourse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            course.setCourseStateActivity(Course.CourseState.CHALLENGE_NAVIGATION);
            EventBus.getDefault().postSticky(course);
            ActivityStarter.startActivity(v.getContext(), course.getCourseStateActivity().getActivityClass());
        }
    };
}
