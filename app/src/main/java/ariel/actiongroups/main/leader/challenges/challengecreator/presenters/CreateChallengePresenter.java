package ariel.actiongroups.main.leader.challenges.challengecreator.presenters;

import android.content.Context;

import ariel.actiongroups.main.common.challenges.Challenge;

public interface CreateChallengePresenter {

    void saveChallengeDataBases(Context context, Challenge challenge);

    void addObjectiveToChallenge();

    void onDestroy();

    //void saveChallengeDataBases(Context context, Challenge challenge);
}
