package ariel.actiongroups.main.common.courses;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;

public class Course extends ActionGroupsEntity{

    private List<Group> groups;
    private List<Challenge> challenges;

    public Course(String name, String description, String imagePath, List<Challenge> challenges) {
        super(name, description, imagePath);
        this.groups = new ArrayList<>(); //All courses starts with no associated groups
        this.challenges = challenges;
    }

    public Course() { //Convenience constructor
        super("My course", "This is a professional course");
        this.groups = new ArrayList<>();
        this.challenges = new ArrayList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }
}
