package ariel.actiongroups.main.leader.groups.groupslist.events;

import java.util.List;

public class OnGroupRowsLoadedEvent {

    public List groupRows;

    public OnGroupRowsLoadedEvent(List groupRows) {
        this.groupRows = groupRows;
    }
}
