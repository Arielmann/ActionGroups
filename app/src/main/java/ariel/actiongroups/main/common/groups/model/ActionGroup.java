package ariel.actiongroups.main.common.groups.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ariel.actiongroups.main.common.challenges.model.Challenge;
import ariel.actiongroups.main.common.profiles.models.Leader;
import ariel.actiongroups.main.common.profiles.models.User;

public class ActionGroup {

    private String id;
    private String name;
    private String description;
    private List<Leader> leaders;
    private List<User> users;
    private List<Challenge> challenges;

    //Convenience Constructor
    public ActionGroup() {
        this.id = UUID.randomUUID().toString();
        this.name = "Group name for group Id: " + id;
        this.description = "This is a great group!";
        this.users = new ArrayList<>();
        while(users.size() < 4){
        users.add(new User());
        }
        this.leaders = new ArrayList<>();
        leaders.add(new Leader());
    }

    public String getName() {
        return name;
    }

    public List<Leader> getLeaders() {
        return leaders;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public String getDescription() {
        return description;
    }
}
