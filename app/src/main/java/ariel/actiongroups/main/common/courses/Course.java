package ariel.actiongroups.main.common.courses;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.states.challengenavigator.view.ChallengeNavigationActivity;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentActivity;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;

public class Course extends ActionGroupsEntity{

    /*
    * Course data structure management:
    * Every course gets one unique id which all associated groups will access.
    * Once a group registers a course it will create a copy of it's instance and save
    * it in her courses map under the common course id.
    * */

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

    private List<ActionGroup> groups;
    private List<Challenge> challenges;
    private CourseState courseState = CourseState.GATHER_PAYMENT;
    private @Nullable Challenge currentChallenge;
    private int currentChallengePosition;

    public Course(String id, String name, String description, String imagePath, List<Challenge> challenges, int currentChallengePosition) {
        super(id, name, description, "30/12/1991");
        this.groups = new ArrayList<>(); //All courses starts with no associated groups
        this.challenges = challenges;
        this.currentChallenge = challenges.get(currentChallengePosition);
        this.currentChallengePosition = currentChallengePosition;
    }

    public Course(Course course){ //Copy constructor
        this(course.getId(), course.getName(), course.getDescription(), course.getImageLocalPath(), course.getChallenges(), course.getCurrentChallengePosition());
    }

 /*  public Course() { //Convenience constructor
        super("My course", "This is a professional course");
        this.groups = new ArrayList<>();
        this.challenges = new ArrayList<>();
        this.challenges.add(new Challenge());
        this.challenges.add(new Challenge());
        this.challenges.add(new Challenge());
        this.currentChallenge = challenges.get(0);
    }*/

    public void setCourseStateActivity(CourseState courseState) {
        this.courseState = courseState;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public List<ActionGroup> getGroups() {
        return groups;
    }

    public void setCurrentChallenge(@Nullable Challenge currentChallenge) {
        this.currentChallenge = currentChallenge;
    }

    public void setCurrentChallengePosition(int currentChallengePosition) {
        this.currentChallengePosition = currentChallengePosition;
    }

    @Nullable
    public Challenge getCurrentChallenge() {
        return currentChallenge;
    }

    public CourseState getCourseStateActivity() {
        return courseState;
    }

    public int getCurrentChallengePosition() {
        return currentChallengePosition;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }
}
