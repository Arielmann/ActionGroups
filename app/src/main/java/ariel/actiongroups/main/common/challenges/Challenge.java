package ariel.actiongroups.main.common.challenges;

import android.graphics.Bitmap;
import android.os.Parcelable;

import org.joda.time.LocalDateTime;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class Challenge  {

    private String objectId;
    private String name;
    private String description;
    private String creationDate;
    private String challengeImageLocalPath;

    private String challengeImageUrl;
    private Bitmap challengeImage = ImageUtils.defaultProfileImage;
    private boolean isSilenced = false;

    private List<ActionGroup> targetGroups;

    private List<String> objectives;
    private String endTime;
    private String startTime;
    private String endDate;
    private String startDate;
    private int positionInCourse;

    //Convenience Constructor
    public Challenge(int positionInCourse) {
        this.name = "Challenge Name";
        this.description = "Challenge Description";
        this.positionInCourse = positionInCourse;
        this.targetGroups = new ArrayList<>();
        this.targetGroups.add(new ActionGroup());
        this.startDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.endDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.startTime = String.valueOf(LocalDateTime.now().toLocalTime());
        this.endTime = String.valueOf(LocalDateTime.now().toLocalTime());
    }

    public Challenge(){}

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


    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPositionInCourse(int positionInCourse) {
        this.positionInCourse = positionInCourse;
    }

    //*************Getters*******************//


    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getChallengeImageLocalPath() {
        return challengeImageLocalPath;
    }

    public String getChallengeImageUrl() {
        return challengeImageUrl;
    }

    public Bitmap getChallengeImage() {
        return challengeImage;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public List<ActionGroup> getTargetGroups() {
        return targetGroups;
    }

    public List<String> getObjectives() {
        return objectives;
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

    public int getPositionInCourse() {
        return positionInCourse;
    }

}
