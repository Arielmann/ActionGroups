package ariel.actiongroups.main.leader.course.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCourseOverviewBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.GoToScreen;
import ariel.actiongroups.main.leader.challenges.challengecreator.view.CreateChallengeActivity;
import ariel.actiongroups.main.leader.course.presenter.CourseOverviewPresenter;
import ariel.actiongroups.main.leader.course.presenter.CourseOverviewPresenterImpl;
import ariel.actiongroups.main.leader.course.presenter.adapter.ChallengeCardsAdapter;


public class CourseOverviewActivity extends AppCompatActivity implements CourseOverviewPresenter.CourseOverviewView {

    private CourseOverviewPresenter presenter;
    private ActivityCourseOverviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_course_overview);
        Intent goToCreateChallengeActivity = new Intent(this, CreateChallengeActivity.class);
        startActivityForResult(goToCreateChallengeActivity, 1);
        ChallengeCardsAdapter adapter = new ChallengeCardsAdapter(this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerView.setAdapter(adapter);
        presenter = new CourseOverviewPresenterImpl(adapter, adapter); //passing adapter as view and presenter for better readability
        GoToScreen.setGoToScreenOnClickListener(binding.addChallenge, this, CreateChallengeActivity.class);
        GoToScreen.setGoToScreenOnClickListener(binding.saveChallenge, this, CreateChallengeActivity.class);
    }

    @Override
    public void refresh() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Challenge challenge = EventBus.getDefault().removeStickyEvent(Challenge.class);
                presenter.addCard(challenge);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
