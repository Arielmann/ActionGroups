package ariel.actiongroups.main.common.courses.coursepresentation;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCoursePresentationBinding;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class CoursePresentationActivity extends AppCompatActivity {

    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_presentation);
        ActivityCoursePresentationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_presentation);
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        setDataInTV(course, binding);
        binding.goToNextCourseStateActivityButton.setOnClickListener(onJoinCourseButtonClicked);
    }

    private void setDataInTV(Course course, ActivityCoursePresentationBinding binding) {
        binding.courseNameInDetailsScreenTV.setText(course.getName());
        binding.descriptionInDetailsScreenTV.setText(course.getDescription());
        //binding.leaderNameInDetailsScreenTV.setText(course.getLeader().getName());
    }

    View.OnClickListener onJoinCourseButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EventBus.getDefault().postSticky(course);
            course.setCourseStateActivity(Course.CourseState.GATHER_PAYMENT); //TODO: Check whether the user is already in the course instead of automatically passing him to payment again
            ActivityStarter.startActivity(v.getContext(), course.getCourseStateActivity().getActivityClass());
        }
    };
}
