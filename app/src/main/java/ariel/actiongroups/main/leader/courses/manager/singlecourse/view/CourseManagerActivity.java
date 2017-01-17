package ariel.actiongroups.main.leader.courses.manager.singlecourse.view;

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
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.challenges.creator.view.CreateChallengeActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.adapter.ChallengeCardsAdapter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;

public class CourseManagerActivity extends AppCompatActivity implements CourseManagerPresenter.CourseManagerView {

    private CourseManagerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCourseOverviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_overview);
        ActivityStarter.startActivityForResult(this, CreateChallengeActivity.class);
        ChallengeCardsAdapter adapter = new ChallengeCardsAdapter(this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerView.setAdapter(adapter);
        presenter = new CourseManagerPresenterImpl(adapter, adapter); //passing adapter as view and presenter for better readability
        ActivityStarter.setStartActivityOnClickListener(binding.addChallenge, this, CreateChallengeActivity.class);
        ActivityStarter.setStartActivityOnClickListener(binding.saveChallenge, this, CourseManagerActivity.class);
    }

    @Override
    public void refresh() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                Challenge challenge = EventBus.getDefault().removeStickyEvent(Challenge.class);
                presenter.addCard(challenge);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }
}
