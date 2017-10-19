package ariel.actiongroups.main.leader.courses.creator.singlecourse.presenter;

import org.json.JSONException;

import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;

public interface CourseDesignerPresenter {

    void removeCard(Challenge challenge);
    void addCard(Challenge challenge);
    void initDummyChallenges(List<Challenge> challenges);
    void setChallenges(List<Challenge> challenges);
    void saveCourseToDataBases(Course course) throws JSONException;

    void onDestroy();
}
