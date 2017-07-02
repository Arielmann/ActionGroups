package ariel.actiongroups.main.common.courses.states.gatherpayment.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnUserRegistrationToCourseFailure;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnUserRegistrationToCourseSuccess;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.profiles.models.User;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.events.OnCourseUploadFailure;

public class RegisterUseToCourseService extends IntentService {

    @Inject
    @Named(AppStrings.BACKENDLESS_COURSES)
    IDataStore<Course> coursesStorage;

    @Inject
    @Named(AppStrings.BACKENDLESS_CHALLENGES)
    IDataStore<Map> challengesStorage;

    private static final String TAG = RegisterUseToCourseService.class.getSimpleName();

    public RegisterUseToCourseService() {
        super(RegisterUseToCourseService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Course course = EventBus.getDefault().removeStickyEvent(Course.class);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        setRelationBetweenCourseAndUser(course);
    }

    private void uploadCourseToDataBases(final Course course) {
        //setRelationBetweenCourseAndUser();


        if (course.getChallenges().get(0) != null) {
         /*   Map<String, Object> courseMap = new HashMap<>();
            courseMap.put(AppStrings.NAME, course.getName());
            courseMap.put(AppStrings.DESCRIPTION, course.getDescription());
            courseMap.put(AppStrings.STATE, course.getCourseStateName());
            coursesStorage.save(courseMap, new AsyncCallback<Map>() {
                @Override
                public void handleResponse(Map response) {
                    if (response != null) {
                        Log.d(TAG, "Course named + " + course.getName() + " was succesfully uploaded. details: " + response.toString());
                        uploadCourseChallengesToServer(response, course);
                    } else {
                        Log.d(TAG, "Course named" + course.getName() + "Challenges array is empty");
                        EventBus.getDefault().post(new OnCourseUploadFailure("Oops.. Your course must have at least 1 challenge"));
                    }
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Log.d(TAG, "Course was not saved to Backendless. Error: " + fault.toString());
                    EventBus.getDefault().post(new OnCourseUploadFailure(fault.getMessage()));
                }
            });*/
        }
    }

    private void setRelationBetweenCourseAndUser(final Course course) {
        List<User> userInArrayList = new ArrayList<>();
        userInArrayList.add(new User());
        // coursesStorage.setRelation(course, AppStrings.MEMBERS + ":" + AppStrings.BACKENDLESS_COURSES + ":n", userInArrayList);
        coursesStorage.setRelation(course, AppStrings.MEMBERS, userInArrayList, new AsyncCallback<Integer>() {
            @Override
            public void handleResponse(Integer response) {
                EventBus.getDefault().post(new OnUserRegistrationToCourseSuccess());

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                EventBus.getDefault().post(new OnUserRegistrationToCourseFailure("Course Registration failed. reason: " + fault.getMessage()));
            }
        });
    }
}





