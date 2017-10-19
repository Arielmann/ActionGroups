package ariel.actiongroups.main.leader.groups.creator.events;

public class OnGroupUploadFailureEvent {

    String error;

    public OnGroupUploadFailureEvent(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
