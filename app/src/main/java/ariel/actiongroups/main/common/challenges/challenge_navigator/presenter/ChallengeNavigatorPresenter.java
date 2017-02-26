package ariel.actiongroups.main.common.challenges.challenge_navigator.presenter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import ariel.actiongroups.main.common.courses.Course;

public interface ChallengeNavigatorPresenter {

    void createViewPagerAdapter(FragmentActivity activity, ViewPager viewPager, Intent intent);
    void onDestroy();
    void updateChallengeData(Course course);
}
