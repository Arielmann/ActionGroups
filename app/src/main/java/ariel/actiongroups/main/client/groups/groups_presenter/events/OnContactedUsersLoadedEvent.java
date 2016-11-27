package ariel.actiongroups.main.client.groups.groups_presenter.events;

import ariel.actiongroups.main.client.groups.groups_presenter.model.GroupRow;

/**
 * Created by home on 11/4/2016.
 */
public class OnContactedUsersLoadedEvent {

    public GroupRow[] groupRows;

    public OnContactedUsersLoadedEvent(GroupRow[] groupRows) {
        this.groupRows = groupRows;
    }
}
