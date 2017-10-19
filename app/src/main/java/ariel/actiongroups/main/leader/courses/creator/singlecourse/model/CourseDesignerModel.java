package ariel.actiongroups.main.leader.courses.creator.singlecourse.model;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.challenges.User;

public class CourseDesignerModel {

    private static CourseDesignerModel model;
    private List<User> challenges;

    public static CourseDesignerModel getInstance()
    {
        if(model == null) {
            model = new CourseDesignerModel();
        }
            return model;
    }

    private CourseDesignerModel() {
        challenges = new ArrayList<>();
    }

    public List<User> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<User> challenges) {
        this.challenges = challenges;
    }
}
