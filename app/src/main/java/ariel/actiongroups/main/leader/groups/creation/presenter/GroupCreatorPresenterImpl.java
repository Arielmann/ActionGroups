package ariel.actiongroups.main.leader.groups.creation.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.backend.ServerCommunicator;
import ariel.actiongroups.main.common.backend.ServerDataProviderDelegations;
import ariel.actiongroups.main.common.groups.model.ActionGroup;

public class GroupCreatorPresenterImpl implements GroupCreatorPresenter{

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
    }

    private void saveGroupToLocalDB(){}


   /* @Override
    public void saveGroupToServer(Context context, ActionGroup group) {
        ServerDataProviderDelegations.RegisterGroupDelegate  groupSaver = ServerDataProvider.getInstance(context);
        groupSaver.registerNewGroup(context, group);
    }*/
}
