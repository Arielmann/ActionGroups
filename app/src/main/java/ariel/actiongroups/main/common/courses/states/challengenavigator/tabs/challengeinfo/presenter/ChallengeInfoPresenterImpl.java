package ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.presenter;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModel;
import ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModelDelegations;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.view.ChallengeDescriptionTabFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.view.ChallengeInfoTabView;

public class ChallengeInfoPresenterImpl implements ChallengeDescriptionPresenter {

    private static final String TAG = ChallengeInfoPresenterImpl.class.getSimpleName();
    private ChallengeNavigatorModelDelegations.ChallengeInfoDelegate model;
    private ChallengeInfoTabView view;

    public ChallengeInfoPresenterImpl(ChallengeDescriptionTabFrag challengeInfoTabView) {
        this.model = ChallengeNavigatorModel.getInstance();
        this.view = challengeInfoTabView;
        this.view.setChallengeDataInViews(model.getChallenge());
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void dummyUpdateChallengeData(Course course) {
        int nextChallengePosition = course.getCurrentChallengePosition() + 1;
        Challenge nextChallenge = course.getChallenges().get(nextChallengePosition);
        course.setCurrentChallenge(nextChallenge);
        course.setCurrentChallengePosition(nextChallengePosition);
        model.setChallenge(course.getCurrentChallenge());
    }

    @Override
    public Course getCourse() {
        return model.getCourse();
    }

}
