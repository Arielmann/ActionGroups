package ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.presenter;

import ariel.actiongroups.main.common.courses.Course;

public interface ChallengeDescriptionPresenter {
    void onDestroy();

    void dummyUpdateChallengeData(Course course);

    Course getCourse();
    //  void setDataInViews();
}
