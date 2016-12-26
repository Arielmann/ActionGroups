package ariel.actiongroups.main.leader.challenges.challengecreator.views;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import net.danlew.android.joda.JodaTimeAndroid;

import ariel.actiongroups.main.common.utils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;
import ariel.actiongroups.main.leader.challenges.challengecreator.presenters.CreateChallengePresenterImpl;

public class ChallengesCreatorActivity extends ViewPagerActivity {

    private static final String CHALLENGE_CREATOR = ChallengesCreatorActivity.class.getName();
    private CreateChallengePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setupViewPager(super.getViewPager());
        presenter = new CreateChallengePresenterImpl();
        Log.d(CHALLENGE_CREATOR, "Challenge Creator created");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeCreatorFrag(), "Challenge");
        adapter.addFragment(new ChallengeSettingsFrag(), "Settings");
        viewPager.setAdapter(adapter);
    }

    public CreateChallengePresenterImpl getPresenter() {
        return presenter;
    }


}
