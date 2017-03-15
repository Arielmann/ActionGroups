package ariel.actiongroups.main.common.challenges.challengenavigator.presenter;

import ariel.actiongroups.main.common.challenges.challengenavigator.model.ChallengeNavigatorModel;
import ariel.actiongroups.main.common.challenges.challengenavigator.model.ChallengeNavigatorModelDelegations;
import ariel.actiongroups.main.common.courses.Course;

public class ChallengeNavigatorPresenterImpl implements ChallengeNavigatorPresenter {

    private String TAG = ChallengeNavigatorPresenterImpl.class.getSimpleName();
    private ChallengeNavigatorModelDelegations.AllModelsDelegate model = ChallengeNavigatorModel.getInstance();

    public ChallengeNavigatorPresenterImpl() {
    }

    @Override
    public void updateChallengeData(Course course) {
        if (course.getCurrentChallenge() != null) {
            model.setChallenge(course.getCurrentChallenge());
        } else {
            throw new RuntimeException("Current challenge is not available. app crashes");
        }
    }

    @Override
    public void onDestroy() {

    }
}


   /* private Bundle createArgs(String key, Object value) {
        Bundle args = new Bundle();
        args.putParcelable(key, (Parcelable) value);
        return args;
    }

    private Map createArgsMap(Activity activity, Intent intent){
        Map<String, Bundle> parsedIntentMap = new HashMap();
        Bundle challengeFragArgs = createArgs(activity.getString(R.string.challenge_object), Parcels.unwrap(intent. //Get challenge model from previous activity
                getParcelableExtra(activity.getString(R.string.challenge_object))));
        parsedIntentMap.put(activity.getString(R.string.challenge_object), challengeFragArgs);
        return parsedIntentMap;
    }
*/

/*
* 28.12.16
*
* Trying to figure out how to design ChallengeNavigationModel. Looks like I'm going for the single model for better access when want
* to update it while not viewing the screen related to the updated data.
* options are one model with delegate for each fragment or separate model for each fragment in the component
*
* Event bus might be a better option than intents to pass data through a few classes,
* especially when not all classes actually need it and just pass it on
* */