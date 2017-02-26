package ariel.actiongroups.main.common.challenges.challenge_navigator.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.challenge_navigator.presenter.ChallengeNavigatorPresenter;
import ariel.actiongroups.main.common.challenges.challenge_navigator.presenter.ChallengeNavigatorPresenterImpl;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupdetails.GroupDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerActivity;
import ariel.actiongroups.main.common.utils.viewpagerutils.ViewPagerAdapter;

public class ChallengeNavigationActivity extends ViewPagerActivity implements ChallengeNavigationView {

   private ChallengeNavigatorPresenter presenter;
   private ActionGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view is defined in super class
        group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        Course course = EventBus.getDefault().removeStickyEvent(Course.class);
        presenter = new ChallengeNavigatorPresenterImpl(this);
        presenter.updateChallengeData(course);
        presenter.createViewPagerAdapter(this, super.getViewPager(), getIntent());
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
    public void setViewPagerAdapter(ViewPagerAdapter adapter) {
        super.getViewPager().setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}

