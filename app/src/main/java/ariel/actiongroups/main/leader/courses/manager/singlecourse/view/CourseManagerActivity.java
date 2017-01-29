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
import ariel.actiongroups.main.common.courses.coursedetails.view.CourseDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.abstractutils.GenericRecyclerViewInterface;
import ariel.actiongroups.main.leader.challenges.creator.view.CreateChallengeActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter.ChallengeCardsAdapter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;

public class CourseManagerActivity extends AppCompatActivity implements GenericRecyclerViewInterface {

    private CourseManagerPresenter presenter;
    private ChallengeCardsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCourseOverviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_overview);
        ActivityStarter.startActivityForResult(this, CreateChallengeActivity.class);
        adapter = new ChallengeCardsAdapter(this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerView.setAdapter(adapter);
        presenter = new CourseManagerPresenterImpl(this); //passing adapter as view and presenter for better readability
        ActivityStarter.setStartActivityOnClickListener(binding.addChallenge, this, CreateChallengeActivity.class);
        ActivityStarter.setStartActivityOnClickListener(binding.saveChallenge, this, CourseDetailsActivity.class);
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
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}
