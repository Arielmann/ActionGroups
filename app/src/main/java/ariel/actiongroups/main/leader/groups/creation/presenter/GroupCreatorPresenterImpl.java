package ariel.actiongroups.main.leader.groups.creation.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.backend.ServerCommunicator;
import ariel.actiongroups.main.common.backend.ServerDataProviderDelegations;
import ariel.actiongroups.main.common.groups.model.ActionGroup;

public class GroupCreatorPresenterImpl implements GroupCreatorPresenter{

    private static final String DEFAULT_CUSTOM_CHANNEL = "Default custom channel";

    @Override
    public void saveGroupToDataBases(Context context, ActionGroup group) {
        saveGroupToServer(context, group);
        saveGroupToLocalDB();
    }

    @Override
    public void onDestroy() {
    }

    private void saveGroupToServer(Context context, ActionGroup group) {
        ServerDataProviderDelegations.RegisterGroupDelegate groupSaver = ServerCommunicator.getInstance();
        groupSaver.registerNewGroup(context, group);
        //TODO: remove hard coding for saving channel for each group
        groupSaver.registerToPushNotificationsCustomChannel(DEFAULT_CUSTOM_CHANNEL);
    }

    private void saveGroupToLocalDB(){}


   /* @Override
    public void saveGroupToServer(Context context, ActionGroup group) {
        ServerDataProviderDelegations.RegisterGroupDelegate  groupSaver = ServerDataProvider.getInstance(context);
        groupSaver.registerNewGroup(context, group);
    }*/
}
