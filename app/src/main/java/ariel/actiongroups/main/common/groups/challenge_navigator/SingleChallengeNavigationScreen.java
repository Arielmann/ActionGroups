package ariel.actiongroups.main.common.groups.challenge_navigator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.challenge_navigator.challenge.ChallengeTabFrag;
import ariel.actiongroups.main.common.groups.challenge_navigator.chat.ChatTabFrag;
import ariel.actiongroups.main.common.groups.challenge_navigator.results.ResultsTabFrag;
import ariel.actiongroups.main.common.groups.group_main.GroupInfoScreen;
import ariel.actiongroups.main.common.utils.GoToScreen;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;

public class SingleChallengeNavigationScreen extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_challenge_navigator);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        Button goToGroupInfoScreen = (Button) findViewById(R.id.goToGroupInfo);
        GoToScreen.setGoToScreenOnClickListener(goToGroupInfoScreen, this, GroupInfoScreen.class);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ResultsTabFrag(), "Results");
        adapter.addFragment(new ChatTabFrag(), "Chat");
        adapter.addFragment(new ChallengeTabFrag(), "Challenge");
        viewPager.setAdapter(adapter);
    }
}

