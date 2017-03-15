package ariel.actiongroups.main.leader.challenges.manager.models;

import ariel.actiongroups.main.common.challenges.Challenge;

public class ChallengeEditorModel {

    private static ChallengeEditorModel model;
    private Challenge challenge;

    public static ChallengeEditorModel getInstance()
    {
        if(model == null) {
            model = new ChallengeEditorModel();
            model.challenge = new Challenge();
        }
        return model;
    }

    private ChallengeEditorModel(){}

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
