package ariel.actiongroups.main.leader.groups.creator.events;

import ariel.actiongroups.main.leader.groups.ActionGroup;

public class OnGroupUploadSucessEvent {

    ActionGroup group;

    public OnGroupUploadSucessEvent(ActionGroup group) {
        this.group = group;
    }

    public ActionGroup getGroup() {
        return group;
    }
}
