package ariel.actiongroups.main.leader.groups.creation.events;

import android.content.Context;

import ariel.actiongroups.main.common.groups.model.ActionGroup;

public class OnGroupCreated {

    public ActionGroup group;
    public Context context;

    public OnGroupCreated(Context context, ActionGroup group) {
        this.group = group;
        this.context = context;
    }
}
