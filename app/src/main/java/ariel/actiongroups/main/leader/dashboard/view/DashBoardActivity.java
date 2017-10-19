package ariel.actiongroups.main.leader.dashboard.view;

import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.courseslist.CourseListFrag;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.leader.groups.groupdetails.GroupDetailsActivity;
import ariel.actiongroups.main.leader.groups.groupslist.view.GroupsListFrag;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;
import ariel.actiongroups.main.leader.groups.groupslist.view.OnActionGroupClicked;

public class DashBoardActivity extends ViewPagerActivity implements OnActionGroupClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view is defined in super class
        createViewPagerAdapter();
    }

    public void createViewPagerAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GroupsListFrag(), AppStrings.UPPER_CASE_GROUPS);
        adapter.addFragment(new CourseListFrag(), AppStrings.UPPER_CASE_COURSES);
        super.getViewPager().setAdapter(adapter);
    }

    @Override
    public void onActionGroupClicked(ActionGroup group) {
        EventBus.getDefault().postSticky(group);
        ActivityStarter.startActivity(this, GroupDetailsActivity.class);
    }
}
