package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;

public interface CourseManagerPresenter {

    void removeCard(Challenge challenge);
    void addCard(Challenge challenge);
    void initDummyChallenges(List<Challenge> challenges);
    void setChallenges(List<Challenge> challenges);
}
