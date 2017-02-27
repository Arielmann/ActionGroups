package ariel.actiongroups.main.leader.courses.manager.singlecourse.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCourseManagerBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.coursedetails.view.CourseDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.GenericRecyclerViewInterface;
import ariel.actiongroups.main.common.utils.listutils.gridview.GridViewLayoutWithHeaderAndFooter;
import ariel.actiongroups.main.common.utils.listutils.gridview.SpanSizeLookUpForHeaderAndFooter;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeManagerActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter.CourseManagerAdapter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;

public class CourseManagerActivity extends AppCompatActivity implements GenericRecyclerViewInterface {

    private CourseManagerPresenter presenter;
    private CourseManagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCourseManagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_manager);
        ActivityStarter.setStartActivityOnClickListener(binding.saveCourse, this, CourseDetailsActivity.class);
        ActivityStarter.setStartActivityForResultOnClickListener(binding.addChallenge, this, ChallengeManagerActivity.class);

        List<Challenge> challenges = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            challenges.add(new Challenge());
        }

        CourseManagerModel.getInstance().setChallenges(challenges);
        adapter = new CourseManagerAdapter(this);
        adapter.setHeader("Get in shape course");
        GridViewLayoutWithHeaderAndFooter layout = new GridViewLayoutWithHeaderAndFooter(this, 3);
        layout.setSpanSizeLookup(new SpanSizeLookUpForHeaderAndFooter(adapter, layout));
        binding.recyclerView.setLayoutManager(layout);
        binding.recyclerView.setAdapter(adapter);
        presenter = new CourseManagerPresenterImpl(this); //passing adapter as view and presenter for better readability
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
