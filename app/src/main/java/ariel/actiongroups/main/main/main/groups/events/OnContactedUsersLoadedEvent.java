package ariel.actiongroups.main.main.main.groups.events;

import java.util.List;

import ariel.actiongroups.main.main.main.groups.model.GroupRow;

/**
 * Created by home on 11/4/2016.
 */
public class OnContactedUsersLoadedEvent {

    public List<GroupRow> groupRows;

    public OnContactedUsersLoadedEvent(List<GroupRow> contactedUsersRows) {
        this.groupRows = contactedUsersRows;
    }
}
