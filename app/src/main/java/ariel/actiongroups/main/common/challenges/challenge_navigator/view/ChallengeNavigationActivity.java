package ariel.actiongroups.main.common.challenges.challenge_navigator.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.challenges.challenge_navigator.presenter.ChallengeNavigatorPresenter;
import ariel.actiongroups.main.common.challenges.challenge_navigator.presenter.ChallengeNavigatorPresenterImpl;
import ariel.actiongroups.main.common.groups.group_info.GroupInfoActivity;
import ariel.actiongroups.main.common.groups.model.ActionGroup;
import ariel.actiongroups.main.common.utils.GoToScreen;
import ariel.actiongroups.main.common.utils.ViewPagerAdapter;
import ariel.actiongroups.main.common.utils.abstractions.ViewPagerActivity;

public class ChallengeNavigationActivity extends ViewPagerActivity implements ChallengeNavigationView {

    ChallengeNavigatorPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content view is defined in super class
        presenter = new ChallengeNavigatorPresenterImpl(this);
        presenter.updateChallengeData(EventBus.getDefault().removeStickyEvent(Challenge.class));
        presenter.createViewPagerAdapter(this, super.getViewPager(), getIntent());
        Button goToGroupInfo = (Button) findViewById(R.id.goToGroupInfo);
        goToGroupInfo.setOnClickListener(goToGroupInfoScreen);
    }

    private View.OnClickListener goToGroupInfoScreen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActionGroup group = new ActionGroup();
            EventBus.getDefault().postSticky(group);
            goToGroupInfo();
        }
    };

    private void goToGroupInfo(){
        GoToScreen.goToNextScreen(this, GroupInfoActivity.class);
    }
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

