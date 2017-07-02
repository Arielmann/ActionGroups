package ariel.actiongroups.main.leader.challenges.manager.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;
import ariel.actiongroups.main.leader.challenges.manager.models.ChallengeEditorModel;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;
import ariel.actiongroups.main.leader.challenges.manager.view.tabs.ChallengeEditorFragment;
import ariel.actiongroups.main.leader.challenges.manager.view.tabs.ChallengeSettingsFragment;

public class ChallengeEditorActivity extends ViewPagerActivity {

    private static final String TAG = ChallengeEditorActivity.class.getName();
    private ChallengeManagerPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setupViewPager(super.getViewPager());
        Challenge challenge = EventBus.getDefault().removeStickyEvent(Challenge.class);
        ChallengeEditorModel.getInstance().setChallenge(challenge);
        presenter = new ChallengeManagerPresenterImpl();
        Log.d(TAG, "Activity created");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeEditorFragment(), AppStrings.UPPER_CASE_CHALLENGE);
        adapter.addFragment(new ChallengeSettingsFragment(),  AppStrings.UPPER_CASE_SETTINGS);
        viewPager.setAdapter(adapter);
    }

    public ChallengeManagerPresenterImpl getPresenter() {
        return presenter;
    }


}
