package ariel.actiongroups.main.leader.courses.manager.singlecourse.model;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;

public class CourseManagerModel {

    private static CourseManagerModel model;
    private List<Challenge> challenges;

    public static CourseManagerModel getInstance()
    {
        if(model == null) {
            model = new CourseManagerModel();
        }
            return model;
    }

    private CourseManagerModel() {
        challenges = new ArrayList<>();
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
