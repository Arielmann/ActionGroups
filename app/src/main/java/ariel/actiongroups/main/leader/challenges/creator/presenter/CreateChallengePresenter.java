package ariel.actiongroups.main.leader.challenges.creator.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.challenges.Challenge;

public interface CreateChallengePresenter {

    void saveChallengeDataBases(Context context, Challenge challenge);

    void addObjectiveToChallenge();

    void onDestroy();

    //void saveChallengeDataBases(Context context, Challenge challenge);
}