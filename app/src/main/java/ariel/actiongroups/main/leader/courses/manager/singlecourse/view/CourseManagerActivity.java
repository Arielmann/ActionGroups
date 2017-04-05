package ariel.actiongroups.main.leader.courses.manager.singlecourse.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCourseManagerBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.coursedetails.view.CourseDetailsActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;
import ariel.actiongroups.main.common.utils.listutils.gridview.GridViewLayoutWithHeaderAndFooter;
import ariel.actiongroups.main.common.utils.listutils.gridview.SpanSizeLookUpForHeaderAndFooter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.leader.challenges.manager.events.OnChallengesEditedEvent;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter.CourseManagerAdapter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;

public class CourseManagerActivity extends AppCompatActivity implements GenericRecyclerViewInterface {

    private CourseManagerPresenter presenter;
    private CourseManagerAdapter adapter;
    private List<Challenge> challenges = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        presenter = new CourseManagerPresenterImpl(this); //passing adapter as view and presenter for better readability
        ActivityCourseManagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_manager);
        binding.saveCourse.setOnClickListener(onSaveCourseClicked);
        binding.addChallenge.setOnClickListener(onAddNewChallengeClicked);
        presenter.initDummyChallenges(challenges);
        presenter.setChallenges(challenges);
        CourseManagerModel.getInstance().setChallenges(challenges); //TODO: Mock call to set method. remove when done
        adapter = new CourseManagerAdapter(this);
        adapter.setHeader("Get in shape course");
        GridViewLayoutWithHeaderAndFooter layout = new GridViewLayoutWithHeaderAndFooter(this, 3);
        layout.setSpanSizeLookup(new SpanSizeLookUpForHeaderAndFooter(adapter, layout));
        binding.recyclerView.setLayoutManager(layout);
        binding.recyclerView.setAdapter(adapter);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            adapter.notifyDataSetChanged();
        }
    }*/

    @Override
    protected void onDestroy() {
        presenter = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

    private View.OnClickListener onAddNewChallengeClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Challenge challenge = new Challenge();
            presenter.addCard(challenge);
            EventBus.getDefault().postSticky(challenge);
            //There is no returned result, instead communicating
            // with OnChallengedChangedEvent but ActivityForResult it makes sure the caller stays alive
            ActivityStarter.startActivityForResult(CourseManagerActivity.this, ChallengeEditorActivity.class);
        }
    };

    private View.OnClickListener onSaveCourseClicked = new View.OnClickListener() {
        String courseId  = UUID.randomUUID().toString();
        @Override
        public void onClick(View view) {
            Course course = new Course(courseId, adapter.getHeader(), "This is get in shape course", ImageUtils.testImagePath, challenges, 0);
            EventBus.getDefault().postSticky(course);
            //There is no returned result, instead communicating
            // with OnChallengedChangedEvent but ActivityForResult it makes sure the caller stays alive
            ActivityStarter.startActivity(view.getContext(), CourseDetailsActivity.class);
        }
    };

    @Subscribe
    public void onChallengesOrderChangedEvent(OnChallengesEditedEvent event) {
        adapter.notifyDataSetChanged();
    }

}

