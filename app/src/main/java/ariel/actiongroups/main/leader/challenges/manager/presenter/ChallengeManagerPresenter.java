package ariel.actiongroups.main.leader.challenges.manager.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.challenges.Challenge;

public interface ChallengeManagerPresenter {

    void saveChallengeDataBases(Context context, Challenge challenge);

    void addObjectiveToChallenge();

    void onDestroy();

    void changeChallengePositionInArray(int oldPosition, int newPosition);

    //void saveChallengeDataBases(Context context, Challenge challenge);
}
