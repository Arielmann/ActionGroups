package ariel.actiongroups.main.common.courses;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.states.challengenavigator.view.ChallengeNavigationActivity;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentActivity;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.users.models.Leader;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;
import ariel.actiongroups.main.common.utils.listutils.ListPresentable;


public class Course implements ListPresentable {

    /*
    * Course data structure management:
    * Every course gets one unique objectId which all associated groups will access.
    * Once a group registers a course it will create a copy of it's instance and save
    * it in its courses map under the common course objectId.
    */

    public enum CourseState {
        GATHER_PAYMENT(GatherPaymentActivity.class),
        CHALLENGE_NAVIGATION(ChallengeNavigationActivity.class);

        private Class activityClass;

        CourseState(Class activityClass) {
            this.activityClass = activityClass;
        }

        public Class getActivityClass() {
            return activityClass;
        }
    }

    private String objectId;

    private String name;

    private String description;

    //TODO: add Backendless date field named "created"

    private String imageLocalPath;

    private String imageUrl;

    private Bitmap image = ImageUtils.defaultProfileImage;

    private boolean isSilenced = false;

    private Leader leader;

    private @Nullable List<ActionGroup> groups;

    private @Nullable List<Challenge> challenges;

    private CourseState state;

    private @Nullable Challenge currentChallenge;

    private int currentChallengePosition;


    public Course(String name, Leader leader, String description, String imagePath, @Nullable List<Challenge> challenges, int currentChallengePosition) {
        this.name = name;
        this.description = description;
        this.leader = leader;
        this.groups = new ArrayList<>(); //All courses starts with no associated groups
        this.challenges = challenges;
        if (challenges != null) {
            this.currentChallenge = challenges.get(currentChallengePosition);
        }
        this.currentChallengePosition = currentChallengePosition;
        setImageUrl(imagePath);
        setImageLocalPath(imagePath);
        state = CourseState.GATHER_PAYMENT;
    }

    public Course(Course course) { //Copy constructor
        this(course.getName(), course.getLeader(), course.getDescription(), course.getImageLocalPath(), course.getChallenges(), course.getCurrentChallengePosition());
    }

   public Course() {} //Backendless constructor

    //**Setters**//

    public void setObjectId(String objectId ) {
        this.objectId = objectId;
    }

    public void setImage(Bitmap entityImageBitmap) {
        this.image = entityImageBitmap;
    }

    public void setImageLocalPath(String entityImageLocalPath) {
        this.imageLocalPath = entityImageLocalPath;
    }

    public void setImageUrl(String entityImageUrl) {
        this.imageUrl = entityImageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSilenced(boolean silenced) {
        isSilenced = silenced;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public void setCourseStateActivity(CourseState courseState) {
        this.state = courseState;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    @Nullable
    public List<ActionGroup> getGroups() {
        return groups;
    }

    public void setCurrentChallenge(@Nullable Challenge currentChallenge) {
        this.currentChallenge = currentChallenge;
    }

    public void setCurrentChallengePosition(int currentChallengePosition) {
        this.currentChallengePosition = currentChallengePosition;
    }

    //**Getters**//
    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLocalPath() {
        return imageLocalPath;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Nullable
    public Challenge getCurrentChallenge() {
        return currentChallenge;
    }

    public CourseState getCourseStateActivity() {
        return state;
    }

    public int getCurrentChallengePosition() {
        return currentChallengePosition;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public Leader getLeader() {
        return leader;
    }

    public String getCourseStateName() {
        return state.name();
    }

}