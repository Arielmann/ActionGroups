package ariel.actiongroups.main.leader.groups.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.resources.AppStrings;

import ariel.actiongroups.main.leader.courses.creator.singlecourse.events.OnCourseUploadFailure;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.services.CourseUploadService;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.leader.groups.creator.events.OnGroupUploadFailureEvent;
import ariel.actiongroups.main.leader.groups.creator.events.OnGroupUploadSucessEvent;


public class GroupUploadService extends IntentService {

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_ACTION_GROUPS)
    IDataStore<ActionGroup> groupStorage;

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_CHALLENGES)
    IDataStore<User> usersStorage;

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_LEADERS)
    IDataStore<Map> leadersStorage;


    private static final String TAG = CourseUploadService.class.getSimpleName();

    public GroupUploadService() {
        super(CourseUploadService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        uploadCourseToDataBases(group);
    }

    private void uploadCourseToDataBases(final ActionGroup group) {
        if (group.getUsers().get(0) != null) {

            groupStorage.save(group, new AsyncCallback<ActionGroup>() {
                @Override
                public void handleResponse(ActionGroup response) {
                    if (response != null) {
                        Log.d(TAG, "Course named + " + group.getName() + " was succesfully uploaded. details: " + response.toString());
                        EventBus.getDefault().post(new OnGroupUploadSucessEvent(group)); //Todo: check for upload success
                    } else{
                        Log.e(TAG, "Course named" + group.getName() + "Response from serve is null");
                        EventBus.getDefault().post(new OnGroupUploadFailureEvent("Oops, there seem a problem. Please try again later"));
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
            Log.d(TAG, "Course named" + group.getName() + "Challenges array is empty");
            EventBus.getDefault().post(new OnCourseUploadFailure("Oops.. Your group must have at least 1 challenge"));
        }
    }

    private void setRelationBetweenGroupAndLeader(final ActionGroup partialInitiallizedCourse){
        List<Map> leaderInArrayList = new ArrayList<>();
        groupStorage.setRelation(partialInitiallizedCourse, AppStrings.BACKENDLESS_TABLE_ACTION_GROUPS, leaderInArrayList);
    }
}
