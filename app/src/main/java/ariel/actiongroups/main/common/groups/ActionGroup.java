package ariel.actiongroups.main.common.groups;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;
import ariel.actiongroups.main.common.profiles.models.Leader;
import ariel.actiongroups.main.common.profiles.models.User;

public class ActionGroup extends ActionGroupsEntity {

    private List<Leader> leaders;
    private List<User> users;
    private List<Challenge> challenges;


    //Convenience Constructor
    public ActionGroup() {
        super();
        setName("Group Name");
        setDescription("This is a great group");
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

    public List<Challenge> getChallenges() {
        return challenges;
    }
}
