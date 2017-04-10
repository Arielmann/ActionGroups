package ariel.actiongroups.main.common.challenges;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.ActionGroupsEntity;

public class Challenge extends ActionGroupsEntity{

    private List<ActionGroup> targetGroups;

    private List<String> objectives;
    private String endTime;
    private String startTime;
    private String endDate;
    private String startDate;
    private int positionInCourse;

    //Convenience Constructor
    public Challenge() {
        super("", "Run 3 times around your building", "Image");
        super.setName("Challenge Id: " + super.getId()) ;
        this.positionInCourse = 1;
        this.targetGroups = new ArrayList<>();
        this.targetGroups.add(new ActionGroup());
        this.startDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.endDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.startTime = String.valueOf(LocalDateTime.now().toLocalTime());
        this.endTime = String.valueOf(LocalDateTime.now().toLocalTime());
    }

  /*  public Challenge(String challengeName, List<String> objectives, String explanation, String endTime, String startTime, String endDate, String startDate) {
        super(challengeName, explanation, "Image");
        super.setName(challengeName);
        super.setDescription(explanation);
        this.objectives = objectives;
        this.endTime = endTime;
        this.startTime = startTime;
        this.endDate = endDate;
        this.startDate = startDate;
    }*/

    //************Setters****************//


    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
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

    public void setPositionInCourse(int positionInCourse) {
        this.positionInCourse = positionInCourse;
    }

    //*************Getters*******************//

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

    public int getPositionInCourse() {
        return positionInCourse;
    }
}
