package ariel.actiongroups.main.common.challenges;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ariel.actiongroups.main.common.groups.model.ActionGroup;

public class Challenge {

    private String challengeId;
    private List<ActionGroup> targetGroups;
    private String challengeName;
    private String description;
    private String endTime;
    private String startTime;
    private String endDate;
    private String startDate;

    //Convenience Constructor
    public Challenge() {
        this.challengeId = UUID.randomUUID().toString();
        this.challengeName = "challenge name for challenge Id: " + challengeId;
        this.targetGroups = new ArrayList<>();
        targetGroups.add(new ActionGroup());
        this.description = "Run 3 times around your building";
        this.startDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.endDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.startTime = String.valueOf(LocalDateTime.now().toLocalTime());
        this.endTime = String.valueOf(LocalDateTime.now().toLocalTime());
    }

    public Challenge(List<ActionGroup> targetGroups, String challengeName, String description, String endTime, String startTime, String endDate, String startDate) {
        this.targetGroups = targetGroups;
        this.challengeName = challengeName;
        this.description = description;
        this.endTime = endTime;
        this.startTime = startTime;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    //************Setters****************//

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getChallengeId() {
        return challengeId;
    }

    public List<ActionGroup> getTargetGroups() {
        return targetGroups;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public String getDescription() {
        return description;
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
