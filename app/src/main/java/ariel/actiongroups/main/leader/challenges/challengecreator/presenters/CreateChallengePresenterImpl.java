package ariel.actiongroups.main.leader.challenges.challengecreator.presenters;

import ariel.actiongroups.main.leader.challenges.challengecreator.ChallengeSettingsModel;

public class CreateChallengePresenterImpl implements CreateChallengePresenter {

    ChallengeSettingsModel model;

    public CreateChallengePresenterImpl() {
        this.model = new ChallengeSettingsModel("September Lions");
    }

    @Override
    public void createChallenge() {
        saveChallengeToDB();
    }

    @Override
    public void addObjectiveToChallenge() {

    }

    @Override
    public void onDestroy() {
//CrateChallengeView = null;
    }

    private void saveChallengeToDB() {

    }
}
