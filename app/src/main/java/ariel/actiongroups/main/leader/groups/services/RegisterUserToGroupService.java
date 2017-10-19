package ariel.actiongroups.main.leader.groups.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.backendless.BackendlessUser;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnGroupRegistrationToCourseFailure;
import ariel.actiongroups.main.common.courses.states.gatherpayment.events.OnGroupRegistrationToCourseSuccess;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.datamanager.DataManager;

public class RegisterUserToGroupService extends IntentService {

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_ACTION_GROUPS)
    IDataStore<ActionGroup> groupsStorage;

    private static final String TAG = RegisterUserToGroupService.class.getSimpleName();

    public RegisterUserToGroupService() {
        super(RegisterUserToGroupService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        appComponent.inject(this);
        setRelationBetweenCourseAndUser(group);
    }

    private void setRelationBetweenCourseAndUser(final ActionGroup group) {
        List<BackendlessUser> userInArrayList = new ArrayList<>();
        userInArrayList.add(DataManager.getInstance().getUser());
        groupsStorage.setRelation(group, AppStrings.USER_GROUP_RELATION, userInArrayList, new AsyncCallback<Integer>() {
            @Override
            public void handleResponse(Integer response) {
                EventBus.getDefault().post(new OnGroupRegistrationToCourseSuccess());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                EventBus.getDefault().post(new OnGroupRegistrationToCourseFailure("Group Registration failed. reason: " + fault.getMessage()));
            }
        });
    }
}





