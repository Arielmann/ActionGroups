package ariel.actiongroups.main.leader.challenges.manager.models;

import ariel.actiongroups.main.common.challenges.User;

public class ChallengeEditorModel {

    private static ChallengeEditorModel model;
    private User challenge;

    public static ChallengeEditorModel getInstance()
    {
        if(model == null) {
            model = new ChallengeEditorModel();
            model.challenge = new User(0);
        }
        return model;
    }

    private ChallengeEditorModel(){}

    public User getChallenge() {
        return challenge;
    }

    public void setChallenge(User challenge) {
        this.challenge = challenge;
    }
}
