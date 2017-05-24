package ariel.actiongroups.main.leader.challenges.manager.presenter;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import ariel.actiongroups.main.common.utils.backendutils.BackendlessHelper;
import ariel.actiongroups.main.common.utils.backendutils.BackendlessHelperDelegations;
import ariel.actiongroups.main.common.utils.backendutils.backendlesshelperdi.BackendlessComponent;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.challenges.manager.events.OnChallengesEditedEvent;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;

public class ChallengeManagerPresenterImpl implements ChallengeManagerPresenter {

    private static final String TAG = ChallengeManagerPresenterImpl.class.getName();
    private List<Challenge> challenges;
    @Inject
    BackendlessHelper serverCommunicator;

    public ChallengeManagerPresenterImpl(BackendlessComponent serverComponent) {
        CourseManagerModel courseManagerModel = CourseManagerModel.getInstance();
        challenges = courseManagerModel.getChallenges();
        serverComponent.inject(this);
    }

    @Override
    public void saveChallengeDataBases(Context context, Challenge challenge) {
        saveChallengeToServer(context, challenge);
        saveChallengeToDB();
    }

    @Override
    public void addObjectiveToChallenge() {

    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void changeChallengePositionInArray(int oldPosition, int newPosition) {
        Challenge challenge = challenges.remove(oldPosition);
        moveChallengesToNextSlot(newPosition);
        challenges.set(newPosition, challenge);
        EventBus.getDefault().post(new OnChallengesEditedEvent()); //notify adapter for change
    }

    private void moveChallengesToNextSlot(int startingPosition) {
        Challenge lastChallenge = challenges.get(challenges.size() - 1);
        for (int i = startingPosition; i < challenges.size() - 2; i++) {
            Challenge oldChallenge = challenges.get(i);
            challenges.set(i + 1, oldChallenge);
        }
        challenges.add(lastChallenge);

    }

    private void saveChallengeToServer(Context context, Challenge challenge) {
        BackendlessHelperDelegations.RegisterChallengeDelegate challengeSaver = BackendlessHelper.getInstance();
        //serverCommunicator.registerNewChallenge(context, challenge);  //TODO: fix nullPointerException in injectModel method on class constructor
        challengeSaver.registerNewChallenge(context, challenge);
    }

    private void saveChallengeToDB() {

    }
}

  /*  @Override
    public void saveChallengeDataBases(Context context, Challenge challenge) {
        ServerDataSaver.getInstance(context).registerNewChallenge(context, challenge);
    }
*/

