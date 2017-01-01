package ariel.actiongroups.main.leader.challenges.challengecreator.presenters;

import android.content.Context;

import ariel.actiongroups.main.common.backend.ServerCommunicator;
import ariel.actiongroups.main.common.backend.ServerDataProviderDelegations;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.challenges.challengecreator.models.ChallengeSettingsModel;

public class CreateChallengePresenterImpl implements CreateChallengePresenter {

    private static final String TAG = CreateChallengePresenterImpl.class.getName();
    private ChallengeSettingsModel model;

    public CreateChallengePresenterImpl() {
        this.model = new ChallengeSettingsModel("September Lions");
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

    private void saveChallengeToServer(Context context, Challenge challenge){
        ServerDataProviderDelegations.RegisterChallengeDelegate challengeSaver = ServerCommunicator.getInstance();
        challengeSaver.registerNewChallenge(context, challenge);
    }

    private void saveChallengeToDB() {

    }
}

   /* private void prepareToGoToNextScreenWithIntent(GenericView view, String objectName, Object data){
        Parcels.wrap(data);
        Intent intent = new Intent();
        intent.putExtra(objectName, (Bundle) data);
    }*/
  /*  @Override
    public void saveChallengeDataBases(Context context, Challenge challenge) {
        ServerDataSaver.getInstance(context).registerNewChallenge(context, challenge);
    }
*/

