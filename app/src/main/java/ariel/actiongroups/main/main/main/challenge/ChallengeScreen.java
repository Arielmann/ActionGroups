package ariel.actiongroups.main.main.main.challenge;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.challenge.results.ResultsTabFrag;
import ariel.actiongroups.main.main.main.challenge.tabBar.fragments.ChallengeTabFrag;
import ariel.actiongroups.main.main.main.challenge.tabBar.fragments.ChatTabFrag;
import ariel.actiongroups.main.main.main.challenge.tabBar.ViewPagerAdapter;

public class ChallengeScreen extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
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
        adapter.addFragment(new ResultsTabFrag(), "Results");
        adapter.addFragment(new ChatTabFrag(), "Chat");
        adapter.addFragment(new ChallengeTabFrag(), "Challenge");
        viewPager.setAdapter(adapter);
    }
}

