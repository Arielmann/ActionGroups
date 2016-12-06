package ariel.actiongroups.main.common.groups.groups_list.events;

import java.util.List;

import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;

/**
 * Created by home on 11/4/2016.
 */
public class OnContactedUsersLoadedEvent {

    public List groupRows;

    public OnContactedUsersLoadedEvent(List groupRows) {
        this.groupRows = groupRows;
    }
}
