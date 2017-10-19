package ariel.actiongroups.main.common.courses.states.gatherpayment.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGatherPaymentBinding;
import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenter;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class GatherPaymentActivity extends AppCompatActivity implements GatherPaymentView {

    @Inject
    GatherPaymentPresenter presenter;

    private Course course;
    private ActionGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        presenter.setView(this);
        ActivityGatherPaymentBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_gather_payment);
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        binding.startCourseButton.setOnClickListener(startCourse);
    }

    View.OnClickListener startCourse = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.registerGroupToCourseInServer(v.getContext(), course, group);
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
