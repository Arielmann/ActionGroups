package ariel.actiongroups.main.leader.groups.creator.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.groups.ActionGroup;

public interface GroupCreatorPresenter {

    void saveGroupToDataBases(Context context, ActionGroup group);
    void onDestroy();
    //void saveGroupToServer(Context context, ActionGroup group);
}
