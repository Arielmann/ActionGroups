package ariel.actiongroups.main.leader.dashboard.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.courseslist.CourseListFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.view.ChallengeDescriptionTabFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.chat.ChatTabFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.results.ResultsTabFrag;
import ariel.actiongroups.main.common.groups.groupslist.view.GroupsListFrag;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;

public class DashBoardActivity extends ViewPagerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void createViewPagerAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GroupsListFrag(), AppStrings.UPPER_CASE_GROUPS);
        adapter.addFragment(new CourseListFrag(), AppStrings.UPPER_CASE_COURSES);
        super.getViewPager().setAdapter(adapter);
    }
}
