package ariel.actiongroups.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.group_info.GroupInfoScreen;
import ariel.actiongroups.main.common.utils.GoToScreen;

public abstract class ViewPagerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.viewPagerTabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
