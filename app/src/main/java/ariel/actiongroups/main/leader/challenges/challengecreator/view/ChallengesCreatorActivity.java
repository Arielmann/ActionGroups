package ariel.actiongroups.main.leader.challenges.challengecreator.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import ariel.actiongroups.main.common.utils.AppStrings;
import ariel.actiongroups.main.common.utils.abstractions.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;
import ariel.actiongroups.main.leader.challenges.challengecreator.presenters.CreateChallengePresenterImpl;
import ariel.actiongroups.main.leader.challenges.challengecreator.view.tabs.ChallengeCreatorFrag;
import ariel.actiongroups.main.leader.challenges.challengecreator.view.tabs.ChallengeSettingsFrag;

public class ChallengesCreatorActivity extends ViewPagerActivity {

    private static final String TAG = ChallengesCreatorActivity.class.getName();
    private CreateChallengePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setupViewPager(super.getViewPager());
        presenter = new CreateChallengePresenterImpl();
        Log.d(TAG, TAG + " created");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeCreatorFrag(), AppStrings.CHALLENGE);
        adapter.addFragment(new ChallengeSettingsFrag(),  AppStrings.SETTINGS);
        viewPager.setAdapter(adapter);
    }

    public CreateChallengePresenterImpl getPresenter() {
        return presenter;
    }


}
