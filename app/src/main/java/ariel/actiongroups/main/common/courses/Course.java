package ariel.actiongroups.main.common.courses;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;

public class Course extends ActionGroupsEntity{

    private List<ActionGroup> groups;
    private List<Challenge> challenges;
    private @Nullable Challenge currentChallenge;
    private boolean isActive;

    public Course(String name, String description, String imagePath, List<Challenge> challenges, int currentChallengePosition) {
        super(name, description, imagePath);
        this.groups = new ArrayList<>(); //All courses starts with no associated groups
        this.challenges = challenges;
        this.currentChallenge = challenges.get(currentChallengePosition);
    }

    public Course() { //Convenience constructor
        super("My course", "This is a professional course");
        this.groups = new ArrayList<>();
        this.challenges = new ArrayList<>();
        this.challenges.add(new Challenge());
        this.challenges.add(new Challenge());
        this.challenges.add(new Challenge());
        this.currentChallenge = challenges.get(0);
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

    public List<ActionGroup> getGroups() {
        return groups;
    }

    @Nullable
    public Challenge getCurrentChallenge() {
        return currentChallenge;
    }
}
