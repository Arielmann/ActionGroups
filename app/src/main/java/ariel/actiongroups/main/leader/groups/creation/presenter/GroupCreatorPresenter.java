package ariel.actiongroups.main.leader.groups.creation.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.groups.model.ActionGroup;

public interface GroupCreatorPresenter {

    void saveGroupToDataBases(Context context, ActionGroup group);
    void onDestroy();
    //void saveGroupToServer(Context context, ActionGroup group);
}
