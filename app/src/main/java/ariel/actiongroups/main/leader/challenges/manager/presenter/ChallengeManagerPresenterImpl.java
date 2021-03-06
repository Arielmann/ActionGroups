package ariel.actiongroups.main.leader.challenges.manager.presenter;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelper;
import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelperDelegations;
import ariel.actiongroups.main.leader.challenges.manager.events.OnChallengesEditedEvent;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.model.CourseDesignerModel;

public class ChallengeManagerPresenterImpl implements ChallengeManagerPresenter {

    private static final String TAG = ChallengeManagerPresenterImpl.class.getName();
    private List<User> challenges;

    public ChallengeManagerPresenterImpl() {
        CourseDesignerModel courseManagerModel = CourseDesignerModel.getInstance();
        challenges = courseManagerModel.getChallenges();
    }

    @Override
    public void saveChallengeDataBases(Context context, User challenge) {
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
        User challenge = challenges.remove(oldPosition);
        moveChallengesToNextSlot(newPosition);
        challenges.set(newPosition, challenge);
        EventBus.getDefault().post(new OnChallengesEditedEvent()); //notify adapter for change
    }

    private void moveChallengesToNextSlot(int startingPosition) {
        User lastChallenge = challenges.get(challenges.size() - 1);
        for (int i = startingPosition; i < challenges.size() - 2; i++) {
            User oldChallenge = challenges.get(i);
            challenges.set(i + 1, oldChallenge);
        }
        challenges.add(lastChallenge);

    }

    private void saveChallengeToServer(Context context, User challenge) {
        BackendlessHelperDelegations.RegisterChallengeDelegate challengeSaver = BackendlessHelper.getInstance();
        challengeSaver.registerNewChallenge(context, challenge);
    }

    private void saveChallengeToDB() {

    }
}

  /*  @Override
    public void saveChallengeDataBases(Context context, User challenge) {
        ServerDataSaver.getInstance(context).registerNewChallenge(context, challenge);
    }
*/

