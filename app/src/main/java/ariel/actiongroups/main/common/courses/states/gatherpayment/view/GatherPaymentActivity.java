package ariel.actiongroups.main.common.courses.states.gatherpayment.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGatherPaymentBinding;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenter;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenterImpl;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class GatherPaymentActivity extends AppCompatActivity implements GatherPaymentView {

    private Course course;

    GatherPaymentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new GatherPaymentPresenterImpl(this);
        ActivityGatherPaymentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gather_payment);
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        binding.startCourseButton.setOnClickListener(startCourse);
    }

    View.OnClickListener startCourse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EventBus.getDefault().postSticky(course);
            presenter.registerUserToCourseInServer(v.getContext());
            course.setCourseStateActivity(Course.CourseState.CHALLENGE_NAVIGATION);
        }


    };

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void goToNextScreen() {
            ActivityStarter.startActivity(this, course.getCourseStateActivity().getActivityClass());
    }

    @Override
    public Context getContext() {
        return this;
    }
}
