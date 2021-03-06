package ariel.actiongroups.main.leader.courses.creator.singlecourse.presenter;

import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;

import java.util.List;

import javax.inject.Inject;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.utils.backendutils.NetworkHelper;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadSuccess;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.model.CourseDesignerModel;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.services.CourseUploadService;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.view.CourseDesignerView;

public class CourseDesignerPresenterImpl implements CourseDesignerPresenter {

    private static final String TAG = CourseSearchViewPresenterImpl.class.getSimpleName();

    private CourseDesignerView view;

    @Inject
    NetworkHelper networkHelper;

    public CourseDesignerPresenterImpl(CourseDesignerView view, AppComponent appComponent) {
        appComponent.inject(this);
        this.view = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void removeCard(User challenge) {
        view.refreshAdapter();
    }

    @Override
    public void addCard(User challenge) {
        List<User> dataSet = CourseDesignerModel.getInstance().getChallenges();
        dataSet.add(challenge);
        view.refreshAdapter();
    }

    @Override
    public void initDummyChallenges(List<User> challenges) {
        for (int i = 0; i < 10; i++) {
            User challenge = new User(i);
            challenge.setName("User " + i);
            challenge.setDescription("User " + i);
            challenges.add(challenge);
        }
    }

    @Override
    public void setChallenges(List<User> challenges) {
        CourseDesignerModel.getInstance().setChallenges(challenges);
    }

    public void saveCourseToDataBases(Course course) throws JSONException {
        EventBus.getDefault().postSticky(course);
        if (networkHelper.hasNetworkAccess(view.getcontext())) {
            view.getcontext().startService(new Intent(view.getcontext(), CourseUploadService.class));
        } else {
            Toast.makeText(view.getcontext(), "You are not connected to the internet", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy(){
        EventBus.getDefault().unregister(this);
    }

    @Subscribe //Thrown from CourseUploadService upon succeful upload
    public void onCourseUploadedSucess(OnCourseUploadSuccess event) {
        EventBus.getDefault().postSticky(event.getCourse());
        view.goToNextScreen();
    }

    @Subscribe //Thrown from CourseUploadService upon succeful upload
    public void onCourseUploadedFailure(OnCourseUploadFailure event) {
            Toast.makeText(view.getcontext(), event.getErrorMessage(), Toast.LENGTH_LONG).show();
    }
}
