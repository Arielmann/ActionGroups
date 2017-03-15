package ariel.actiongroups.main.common.challenges.challengenavigator.tabs.challengeinfo.presenter;

import android.util.Log;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.challenges.challengenavigator.model.ChallengeNavigatorModel;
import ariel.actiongroups.main.common.challenges.challengenavigator.model.ChallengeNavigatorModelDelegations;
import ariel.actiongroups.main.common.challenges.challengenavigator.tabs.challengeinfo.view.ChallengeInfoTabView;
import ariel.actiongroups.main.common.challenges.challengenavigator.tabs.challengeinfo.view.ChallengeInfoTabFrag;
import ariel.actiongroups.main.common.courses.Course;

public class ChallengeInfoPresenterImpl implements ChallengeInfoPresenter {

    private static final String TAG = ChallengeInfoPresenterImpl.class.getSimpleName();
    private ChallengeNavigatorModelDelegations.ChallengeInfoDelegate model;
    private ChallengeInfoTabView view;

    public ChallengeInfoPresenterImpl(ChallengeInfoTabFrag challengeInfoTabView) {
        this.model = ChallengeNavigatorModel.getInstance();
        this.view = challengeInfoTabView;
        view.setChallengeDataInViews(model.getChallenge());
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
        if (course.getCurrentChallenge() != null) {
            model.setChallenge(course.getCurrentChallenge());
        } else { //TODO: debug purposes only, remove when done!!
            model.setChallenge(new Challenge());
            Log.e(TAG, "No challenge found in group");
        }
    }

}
