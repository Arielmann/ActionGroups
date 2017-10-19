package ariel.actiongroups.main.common.home_page;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.groupslist.view.GroupsListFrag;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;

public class HomePage extends ViewPagerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager(super.getViewPager());
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Resources res = getResources();
        adapter.addFragment(new GroupsListFrag(), res.getString(R.string.hot_groups));
        adapter.addFragment(new GroupsListFrag(), res.getString(R.string.my_groups));
        viewPager.setAdapter(adapter);
    }
}
