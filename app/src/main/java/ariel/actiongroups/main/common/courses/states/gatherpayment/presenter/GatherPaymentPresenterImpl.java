package ariel.actiongroups.main.common.courses.states.gatherpayment.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.services.RegisterGroupToCourseService;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentView;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadSuccess;

public class GatherPaymentPresenterImpl implements GatherPaymentPresenter {

    GatherPaymentView view;

    public GatherPaymentPresenterImpl(AppComponent component) {
        EventBus.getDefault().register(this);
    }

    @Override
    public void registerGroupToCourseInServer(Context context, Course course, ActionGroup group) {
        EventBus.getDefault().postSticky(course);
        EventBus.getDefault().postSticky(group);
        context.startService(new Intent(context, RegisterGroupToCourseService.class));
    }

    @Override
    public void setView(GatherPaymentView view) {
        this.view = view;
    }

    @Subscribe //Thrown from RegisterUserToGroupService upon succeful upload
    public void onCourseUploadedSucess(OnCourseUploadSuccess event) {
        view.goToNextScreen();
    }

    @Subscribe //Thrown from RegisterUserToGroupService upon succeful upload
    public void onCourseUploadedFailure(OnCourseUploadFailure event) {
        Toast.makeText(view.getContext(), event.getErrorMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }
}
