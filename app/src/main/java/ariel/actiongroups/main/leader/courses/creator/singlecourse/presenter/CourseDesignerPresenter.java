package ariel.actiongroups.main.leader.courses.creator.singlecourse.presenter;

import org.json.JSONException;

import java.util.List;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.courses.Course;

public interface CourseDesignerPresenter {

    void removeCard(User challenge);
    void addCard(User challenge);
    void initDummyChallenges(List<User> challenges);
    void setChallenges(List<User> challenges);
    void saveCourseToDataBases(Course course) throws JSONException;

    void onDestroy();
}
