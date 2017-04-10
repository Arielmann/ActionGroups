package ariel.actiongroups.main.common.groups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.ActionGroupsEntity;
import ariel.actiongroups.main.common.profiles.models.Leader;
import ariel.actiongroups.main.common.profiles.models.User;

public class ActionGroup extends ActionGroupsEntity {

    private List<Leader> leaders;
    private List<User> users;
    private Map<String, Course> courses;

    //Convenience Constructor
    public ActionGroup() {
        super("Group Name", "This is a great group");
        this.courses = new HashMap<>();
        this.users = new ArrayList<>();
        while(users.size() < 4){
        users.add(new User());
        }
        this.leaders = new ArrayList<>();
        leaders.add(new Leader());
    }

    public List<Leader> getLeaders() {
        return leaders;
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }
}
