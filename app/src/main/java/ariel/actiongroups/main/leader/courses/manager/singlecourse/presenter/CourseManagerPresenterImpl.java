package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import android.content.Intent;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;

import java.util.List;

import javax.inject.Inject;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.utils.backendutils.NetworkHelper;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.events.OnCourseUploadSuccess;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.services.CourseUploadService;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.view.CourseManagerView;

public class CourseManagerPresenterImpl implements CourseManagerPresenter {

    private static final String TAG = CourseSearchViewPresenterImpl.class.getSimpleName();

    private CourseManagerView view;

    @Inject
    NetworkHelper networkHelper;

    public CourseManagerPresenterImpl(CourseManagerView view, AppComponent appComponent) {
        appComponent.inject(this);
        this.view = view;
        EventBus.getDefault().register(this);
    }

    @Override
    public void removeCard(Challenge challenge) {
        view.refreshAdapter();
    }

    @Override
    public void addCard(Challenge challenge) {
        List<Challenge> dataSet = CourseManagerModel.getInstance().getChallenges();
        dataSet.add(challenge);
        view.refreshAdapter();
    }

    @Override
    public void initDummyChallenges(List<Challenge> challenges) {
        for (int i = 0; i < 10; i++) {
            Challenge challenge = new Challenge(i);
            challenge.setName("Challenge " + i);
            challenge.setDescription("Challenge " + i);
            challenges.add(challenge);
        }
    }

    @Override
    public void setChallenges(List<Challenge> challenges) {
        CourseManagerModel.getInstance().setChallenges(challenges);
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
        view.goToNextScreen();
    }

    @Subscribe //Thrown from CourseUploadService upon succeful upload
    public void onCourseUploadedFailure(OnCourseUploadFailure event) {
            Toast.makeText(view.getcontext(), event.getErrorMessage(), Toast.LENGTH_LONG).show();
    }
}
