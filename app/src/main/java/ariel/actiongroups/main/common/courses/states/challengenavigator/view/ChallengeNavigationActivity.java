package ariel.actiongroups.main.common.courses.states.challengenavigator.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.states.challengenavigator.presenter.ChallengeNavigatorPresenter;
import ariel.actiongroups.main.common.courses.states.challengenavigator.presenter.ChallengeNavigatorPresenterImpl;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.view.ChallengeDescriptionTabFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.chat.ChatTabFrag;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.results.ResultsTabFrag;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupdetails.GroupDetailsActivity;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;

public class ChallengeNavigationActivity extends ViewPagerActivity {

   private ChallengeNavigatorPresenter presenter;
   private ActionGroup group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view is defined in super class
        group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        Course course = EventBus.getDefault().removeStickyEvent(Course.class);
        presenter = new ChallengeNavigatorPresenterImpl();
        presenter.updateChallengeData(course);
        createViewPagerAdapter();
        Button goToGroupInfo = (Button) findViewById(R.id.goToGroupInfo);
        goToGroupInfo.setOnClickListener(goToGroupInfoScreen);
    }

    private View.OnClickListener goToGroupInfoScreen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EventBus.getDefault().postSticky(group);
            ActivityStarter.startActivity(view.getContext(), GroupDetailsActivity.class);
        }
    };

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    public void createViewPagerAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ResultsTabFrag(), AppStrings.RESULTS);
        adapter.addFragment(new ChatTabFrag(), AppStrings.CHAT);
        adapter.addFragment(new ChallengeDescriptionTabFrag(), AppStrings.CHALLENGE);
        super.getViewPager().setAdapter(adapter);
    }
}

