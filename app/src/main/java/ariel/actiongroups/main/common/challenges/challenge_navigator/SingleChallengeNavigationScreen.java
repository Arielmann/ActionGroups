package ariel.actiongroups.main.common.challenges.challenge_navigator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.challenge_navigator.challengview.ChallengeViewTabFrag;
import ariel.actiongroups.main.common.challenges.challenge_navigator.chat.ChatTabFrag;
import ariel.actiongroups.main.common.challenges.challenge_navigator.results.ResultsTabFrag;
import ariel.actiongroups.main.common.utils.ViewPagerActivity;
import ariel.actiongroups.main.common.groups.group_info.GroupInfoActivity;
import ariel.actiongroups.main.common.utils.GoToScreen;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;

public class SingleChallengeNavigationScreen extends ViewPagerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view is defined in super class
        setupViewPager(super.getViewPager());
        Button goToGroupInfo = (Button) findViewById(R.id.goToGroupInfo);
        GoToScreen.setGoToScreenOnClickListener(goToGroupInfo, this, GroupInfoActivity.class);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Bundle args = new Bundle();
        adapter.addFragment(new ResultsTabFrag(), "Results");
        adapter.addFragment(new ChatTabFrag(), "Chat");
        adapter.addFragment(new ChallengeViewTabFrag(), "Challenge");
        viewPager.setAdapter(adapter);
    }
}

