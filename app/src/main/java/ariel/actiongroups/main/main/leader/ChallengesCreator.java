package ariel.actiongroups.main.main.leader;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.results.ResultsTabFrag;
import ariel.actiongroups.main.main.main.tabBar.ViewPagerAdapter;
import ariel.actiongroups.main.main.main.tabBar.fragments.ChallengeTabFrag;
import ariel.actiongroups.main.main.main.tabBar.fragments.ChatTabFrag;
import ariel.actiongroups.main.main.support_classes.handlers.FragmentBuilder;

public class ChallengesCreator extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges_creator);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeCreatorFrag(), "Challenge");
        adapter.addFragment(new ChallengeSettingsFrag(), "Settings");
        viewPager.setAdapter(adapter);
    }

}
