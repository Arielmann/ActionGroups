package ariel.actiongroups.main.common.courses.states.gatherpayment.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import ariel.actiongroups.main.common.courses.states.gatherpayment.services.RegisterUseToCourseService;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentView;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.events.OnCourseUploadSuccess;

public class GatherPaymentPresenterImpl implements GatherPaymentPresenter {

    GatherPaymentView view;

    public GatherPaymentPresenterImpl(GatherPaymentView view) {
        this.view = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void registerUserToCourseInServer(Context context) {
        context.startService(new Intent(context, RegisterUseToCourseService.class));
    }

    @Subscribe //Thrown from RegisterUserToCourseService upon succeful upload
    public void onCourseUploadedSucess(OnCourseUploadSuccess event) {
        view.goToNextScreen();
    }

    @Subscribe //Thrown from RegisterUserToCourseService upon succeful upload
    public void onCourseUploadedFailure(OnCourseUploadFailure event) {
        Toast.makeText(view.getContext(), event.getErrorMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }
}
