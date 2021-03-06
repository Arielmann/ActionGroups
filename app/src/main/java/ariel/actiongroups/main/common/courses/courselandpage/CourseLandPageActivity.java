package ariel.actiongroups.main.common.courses.courselandpage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;

import ariel.actiongroups.databinding.ActivityCourseLandPageBinding;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class CourseLandPageActivity extends AppCompatActivity {

    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_land_page);
        ActivityCourseLandPageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_land_page);
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        setDataInTV(course, binding);
        binding.goToNextCourseStateActivityButton.setOnClickListener(onJoinCourseButtonClicked);
    }

    private void setDataInTV(Course course, ActivityCourseLandPageBinding binding) {
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
