package ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.presenter;

import ariel.actiongroups.main.common.challenges.challenge_navigator.model.ChallengeNavigatorModel;
import ariel.actiongroups.main.common.challenges.challenge_navigator.model.ChallengeNavigatorModelDelegations;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.view.ChallengeInfoTabView;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.view.ChallengeInfoTabViewImpl;

public class ChallengeInfoPresenterImpl implements ChallengeInfoPresenter {

    ChallengeNavigatorModelDelegations.ChallengeInfoDelegate model;
    ChallengeInfoTabView view;

    public ChallengeInfoPresenterImpl(ChallengeInfoTabViewImpl challengeInfoTabView) {
        this.model = ChallengeNavigatorModel.getInstance();
        this.view = challengeInfoTabView;
        view.setChallengeDataInViews(model.getChallenge());
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
