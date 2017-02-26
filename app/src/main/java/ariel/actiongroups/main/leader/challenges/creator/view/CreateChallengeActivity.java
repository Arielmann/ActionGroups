package ariel.actiongroups.main.leader.challenges.creator.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.leader.challenges.creator.presenter.CreateChallengePresenterImpl;
import ariel.actiongroups.main.leader.challenges.creator.view.tabs.CreateChallengeFragment;
import ariel.actiongroups.main.leader.challenges.creator.view.tabs.ChallengeSettingsFragment;

public class CreateChallengeActivity extends ViewPagerActivity {

    private static final String TAG = CreateChallengeActivity.class.getName();
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
        adapter.addFragment(new CreateChallengeFragment(), AppStrings.CHALLENGE);
        adapter.addFragment(new ChallengeSettingsFragment(),  AppStrings.SETTINGS);
        viewPager.setAdapter(adapter);
    }

    public CreateChallengePresenterImpl getPresenter() {
        return presenter;
    }


}
