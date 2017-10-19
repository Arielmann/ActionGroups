package ariel.actiongroups.main.leader.groups.creator.events;

import android.content.Context;

import ariel.actiongroups.main.leader.groups.ActionGroup;

public class OnGroupCreated {

    public ActionGroup group;
    public Context context;

    public OnGroupCreated(Context context, ActionGroup group) {
        this.group = group;
        this.context = context;
    }
}
