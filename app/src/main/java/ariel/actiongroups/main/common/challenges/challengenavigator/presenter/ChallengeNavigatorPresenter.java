package ariel.actiongroups.main.common.challenges.challengenavigator.presenter;

import ariel.actiongroups.main.common.courses.Course;

public interface ChallengeNavigatorPresenter {

    void updateChallengeData(Course course);
    void onDestroy();
}
