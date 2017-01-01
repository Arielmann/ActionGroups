package ariel.actiongroups.main.common.challenges.challenge_navigator.presenter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.challenges.challenge_navigator.model.ChallengeNavigatorModel;
import ariel.actiongroups.main.common.challenges.challenge_navigator.model.ChallengeNavigatorModelDelegations;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.view.ChallengeInfoTabViewImpl;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.chat.ChatTabFrag;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.results.ResultsTabFrag;
import ariel.actiongroups.main.common.challenges.challenge_navigator.view.ChallengeNavigationView;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;

public class ChallengeNavigatorPresenterImpl implements ChallengeNavigatorPresenter {

    private ChallengeNavigationView view;
    private ChallengeNavigatorModelDelegations.AllModelsDelegate model = ChallengeNavigatorModel.getInstance();

    public ChallengeNavigatorPresenterImpl(ChallengeNavigationView challengeNavigationView) {
        this.view = challengeNavigationView;
    }

    @Override
    public void createViewPagerAdapter(FragmentActivity activity, ViewPager viewPager, Intent intent) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(activity.getSupportFragmentManager());
        String CHALLENGE = "Challenge";
        String CHAT = "Chat";
        String RESULTS = "Results";
        adapter.addFragment(new ResultsTabFrag(), RESULTS);
        adapter.addFragment(new ChatTabFrag(), CHAT);
        adapter.addFragment(new ChallengeInfoTabViewImpl(), CHALLENGE);
        view.setViewPagerAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void updateChallengeData(Challenge challenge) {
        model.setChallenge(challenge);
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