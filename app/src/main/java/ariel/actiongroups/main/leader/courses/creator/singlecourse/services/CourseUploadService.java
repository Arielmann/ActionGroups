package ariel.actiongroups.main.leader.courses.creator.singlecourse.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.algolia.search.saas.Index;
import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelper;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadSuccess;

public class CourseUploadService extends IntentService {

    @Inject
    @Named(AppStrings.ALGOLIA_COURSES_TABLE_NAME)
    Index coursesIndex;

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_COURSE)
    IDataStore<Course> coursesStorage;

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_CHALLENGES)
    IDataStore<Challenge> challengesStorage;

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_LEADERS)
    IDataStore<Map> leadersStorage;

    @Inject
    BackendlessHelper blHelper;

    private static final String TAG = CourseUploadService.class.getSimpleName();

    public CourseUploadService() {
        super(CourseUploadService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Course course = EventBus.getDefault().removeStickyEvent(Course.class);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        uploadCourseToDataBases(course);
    }

    private void uploadCourseToDataBases(final Course course) {
        if (course.getChallenges().get(0) != null) {

            coursesStorage.save(course, new AsyncCallback<Course>() {
                @Override
                public void handleResponse(Course response) {
                    if (response != null) {
                        Log.d(TAG, "Course named + " + course.getName() + " was succesfully uploaded. details: " + response.toString());
                        uploadCourseChallengesToServer(response, course);
                    } else{
                        Log.e(TAG, "Course named" + course.getName() + "Response from serve is null");
                        EventBus.getDefault().post(new OnCourseUploadFailure("Oops, there seem a problem in our servers. Please try again later"));
                    }
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Log.d(TAG, "Course was not saved to Backendless. Error: " + fault.toString());
                    EventBus.getDefault().post(new OnCourseUploadFailure(fault.getMessage()));
                }
            });
        }
        else{
                Log.d(TAG, "Course named" + course.getName() + "Challenges array is empty");
                EventBus.getDefault().post(new OnCourseUploadFailure("Oops.. Your course must have at least 1 challenge"));
            }
    }

    private void setRelationBetweenCourseAndLeader(final Course partialInitiallizedCourse){
        List<Map> leaderInArrayList = new ArrayList<>();
       coursesStorage.setRelation(partialInitiallizedCourse, AppStrings.LEADER_COURSE_RELATION, leaderInArrayList);
    }

    private void setRelationBetweenCourseAndCurrentChallenge(final Course partialInitiallizedCourse, Challenge challange){
        List<Challenge> challengeInArrayList = new ArrayList<>();
        challengeInArrayList.add(challange);
        coursesStorage.setRelation(partialInitiallizedCourse, AppStrings.CURRENT_CHALLENGE_COURSE_RELATION, challengeInArrayList);
    }

    private void uploadCourseChallengesToServer(final Course partialInitilizedCourse, final Course course) {
        final List<Challenge> challangeInArrayList = new ArrayList<>();

        for (Challenge challenge : course.getChallenges()) {
            challengesStorage.save(challenge, new AsyncCallback<Challenge>() {

                @Override
                public void handleResponse(Challenge response) {
                    challangeInArrayList.add(response);
                    if (course.getChallenges().size() == challangeInArrayList.size()) {
                        //PRODUCES NULL POINTER EXCEPTION  - coursesStorage.setRelation(partialInitilizedCourse, AppStrings.USC_CURRENT_CHALLENGE + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":1", savedChallengesMap);
                        coursesStorage.setRelation(partialInitilizedCourse, AppStrings.CHALLANGES_COURSE_RELATION, challangeInArrayList, new AsyncCallback<Integer>() {
                            @Override
                            public void handleResponse(Integer response) {
                                if (response != null) {
                                    Log.d(TAG, "Relation was succefully created between course named + " + course.getName() + " and challenges: " + course.getChallenges().toString());
                                        EventBus.getDefault().post(new OnCourseUploadSuccess(course)); //Todo: check for upload success
                                }
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Log.e(TAG, "Challenges relation creating failed in course " + course.getName() + ". Reason:" + fault.toString());
                                EventBus.getDefault().post(new OnCourseUploadFailure(fault.getMessage()));
                            }
                        });
                    }
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Log.e(TAG, "Challenge was not uploaded in course named " + course.getName() + ". Reason:" + fault.getMessage());
                    EventBus.getDefault().post(new OnCourseUploadFailure(fault.getMessage()));
                }
            });
        }
    }
/*
    private void uploadCourseToSearchEngine(Course course) throws JSONException {
      *//*  coursesIndex.addObjectAsync(new JSONObject()
                .put(AppStrings.ID, course.getObjectId())
                .put(AppStrings.NAME, course.getName())
                .put(AppStrings.LEADER_NAME, course.getLeader().getName())
                .put(AppStrings.LEADER_ID, course.getLeader().getObjectId())
                .put(AppStrings.DESCRIPTION, course.getDescription())
                .put(AppStrings.IMAGE_URL, ImageUtils.testImagePath)
                .put(AppStrings.CREATION_DATE, course.getCreationDate()), null);*//*
        EventBus.getDefault().post(new OnCourseUploadSuccess()); //Todo: check for upload success
    }*/
}
