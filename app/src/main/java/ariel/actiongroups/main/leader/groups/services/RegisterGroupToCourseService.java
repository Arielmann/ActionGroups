package ariel.actiongroups.main.leader.groups.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnGroupRegistrationToCourseFailure;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnGroupRegistrationToCourseSuccess;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.leader.groups.ActionGroup;

public class RegisterGroupToCourseService extends IntentService {

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_COURSE)
    IDataStore<Course> coursesStorage;

    private static final String TAG = RegisterGroupToCourseService.class.getSimpleName();
    private Course course;
    private ActionGroup group;

    public RegisterGroupToCourseService() {
        super(RegisterGroupToCourseService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        course = EventBus.getDefault().removeStickyEvent(Course.class);
        group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        setRelationBetweenCourseAndUser();
    }

    private void setRelationBetweenCourseAndUser() {
        List<ActionGroup> groupInArrayList = new ArrayList<>();
        groupInArrayList.add(group);
        // groupStorage.setRelation(course, AppStrings.MEMBERS + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":n", userInArrayList);
        coursesStorage.setRelation(course, AppStrings.GROUP_COURSE_RELATION, groupInArrayList, new AsyncCallback<Integer>() {
            @Override
            public void handleResponse(Integer response) {
                EventBus.getDefault().post(new OnGroupRegistrationToCourseSuccess());

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                EventBus.getDefault().post(new OnGroupRegistrationToCourseFailure("Course Registration failed. reason: " + fault.getMessage()));
            }
        });
    }
}





