package ariel.actiongroups.main.common.groups.groups_list.events;

import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;

/**
 * Created by home on 11/4/2016.
 */
public class OnContactedUsersLoadedEvent {

    public GroupRow[] groupRows;

    public OnContactedUsersLoadedEvent(GroupRow[] groupRows) {
        this.groupRows = groupRows;
    }
}