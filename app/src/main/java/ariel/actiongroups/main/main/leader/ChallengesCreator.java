package ariel.actiongroups.main.main.leader;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.challenge.tabBar.ViewPagerAdapter;

public class ChallengesCreator extends AppCompatActivity {

    private static final String CHALLENGE_CREATOR = "Challenge Creator";
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
        Log.d(CHALLENGE_CREATOR, "Challenge Creator created");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChallengeCreatorFrag(), "Challenge");
        adapter.addFragment(new ChallengeSettingsFrag(), "Settings");
        viewPager.setAdapter(adapter);
        };
    }
