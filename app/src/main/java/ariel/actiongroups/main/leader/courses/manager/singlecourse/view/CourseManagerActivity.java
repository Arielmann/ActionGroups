package ariel.actiongroups.main.leader.courses.manager.singlecourse.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCourseManagerBinding;
import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.view.SearchCoursesActivity;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.profiles.models.Leader;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.di.SearchComponent;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;
import ariel.actiongroups.main.common.utils.listutils.gridview.GridViewLayoutWithHeaderAndFooter;
import ariel.actiongroups.main.common.utils.listutils.gridview.SpanSizeLookUpForHeaderAndFooter;
import ariel.actiongroups.main.leader.challenges.manager.events.OnChallengesEditedEvent;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter.CourseManagerAdapter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;

public class CourseManagerActivity extends AppCompatActivity implements CourseManagerView {

    private CourseManagerPresenter presenter;
    private CourseManagerAdapter adapter;
    private List<Challenge> challenges = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        AppComponent appComponent = ((ActionGroupsApplication) getApplication()).getAppComponent();
        presenter = new CourseManagerPresenterImpl(this, appComponent);
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
        presenter.onDestroy();
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
            Challenge challenge = new Challenge(challenges.size());
            presenter.addCard(challenge);
            EventBus.getDefault().postSticky(challenge);
            //There is no returned result, instead communicating
            // with OnChallengedChangedEvent but ActivityForResult it makes sure the caller stays alive
            ActivityStarter.startActivityForResult(CourseManagerActivity.this, ChallengeEditorActivity.class);
        }
    };

    private View.OnClickListener onSaveCourseClicked = new View.OnClickListener() {
        String courseId = UUID.randomUUID().toString();

        @Override
        public void onClick(View view) {
            Leader leader = new Leader();
            Course course = new Course(courseId, adapter.getHeader(), leader, "This is get in shape course", ImageUtils.testImagePath, challenges, 0);
            EventBus.getDefault().postSticky(course);

            try {
                presenter.saveCourseToDataBases(course);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Subscribe
    public void onChallengesOrderChangedEvent(OnChallengesEditedEvent event) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void popNoChallengesCreatedError() {
        Toast.makeText(this, "Oops, seems like your course as no challenges at all, please create at least 1 before saving it", Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToNextScreen() {
            ActivityStarter.startActivity(this, SearchCoursesActivity.class);
    }

    @Override
    public Context getcontext() {
        return this;
    }
}

