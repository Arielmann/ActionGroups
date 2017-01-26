package ariel.actiongroups.main.common.challenges;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;

public class Challenge extends ActionGroupsEntity{

    private List<ActionGroup> targetGroups;
    private String endTime;
    private String startTime;
    private String endDate;
    private String startDate;

    //Convenience Constructor
    public Challenge() {
        super("", "Run 3 times around your building", "Image");
        super.setName("challenge name for challenge Id: " + super.getId()) ;
        this.targetGroups = new ArrayList<>();
        this.targetGroups.add(new ActionGroup());
        this.startDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.endDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.startTime = String.valueOf(LocalDateTime.now().toLocalTime());
        this.endTime = String.valueOf(LocalDateTime.now().toLocalTime());
    }

    public Challenge(List<ActionGroup> targetGroups, String challengeName, String description, String endTime, String startTime, String endDate, String startDate) {
        super(challengeName, description, "Image");
        this.targetGroups = targetGroups;
        super.setName(challengeName);
        this.endTime = endTime;
        this.startTime = startTime;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    //************Setters****************//



    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setTargetGroups(List<ActionGroup> targetGroups) {
        this.targetGroups = targetGroups;
    }

    //*************Getters*******************//

    public List<ActionGroup> getTargetGroups() {
        return targetGroups;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

}
