package ariel.actiongroups.main.leader.challenges.manager.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;
import ariel.actiongroups.main.leader.challenges.manager.view.tabs.ChallengeManagerFragment;
import ariel.actiongroups.main.leader.challenges.manager.view.tabs.ChallengeSettingsFragment;

public class ChallengeManagerActivity extends ViewPagerActivity {

    private static final String TAG = ChallengeManagerActivity.class.getName();
    private ChallengeManagerPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setupViewPager(super.getViewPager());
        presenter = new ChallengeManagerPresenterImpl();
        Log.d(TAG, "Activity created");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeManagerFragment(), AppStrings.CHALLENGE);
        adapter.addFragment(new ChallengeSettingsFragment(),  AppStrings.SETTINGS);
        viewPager.setAdapter(adapter);
    }

    public ChallengeManagerPresenterImpl getPresenter() {
        return presenter;
    }


}
