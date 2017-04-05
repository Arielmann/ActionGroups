package ariel.actiongroups.main.common.courses.coursedetails.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.CompoRecyclerViewBinding;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.coursedetails.adapter.CourseDetailsAdapter;
import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.common.courses.coursedetails.presenter.CourseDetailsPresenter;
import ariel.actiongroups.main.common.courses.coursedetails.presenter.CourseDetailsPresenterImpl;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.view.GroupListActivityForResult;
import ariel.actiongroups.main.common.groups.groupslist.view.OnActionGroupClicked;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;
import ariel.actiongroups.main.common.utils.listutils.vh.OnAddEntityVHClicked;

public class CourseDetailsActivity extends AppCompatActivity implements OnActionGroupClicked, OnAddEntityVHClicked {

    /*
    * This activity creates an adapter with a static header and dynamic data.
    *
    * Since startActivityForResult command is required for adding
    * a new group to dataSet from the GroupsListActivityForResult,
    * the activity sends it's OnAddGroupClickedVH interface to the static
    * header that will provoke it upon a user's click.
    *
    * onGroupClicked interface is sent to the dynamic GroupViewHolders
    * in order to start a relevant group activity upon a user's click.
    * */

    private static final String TAG = CourseDetailsActivity.class.getSimpleName();
    private CourseDetailsAdapter adapter;
    private CourseDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CompoRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.compo_recycler_view);
        Course course = EventBus.getDefault().removeStickyEvent(Course.class);
        presenter = new CourseDetailsPresenterImpl(adapter, course); //adapter provides GenericRecyclerViewInterface for this presenter
        presenter.updateModelData();
        initCourseDetailsRecyclerView(binding);
        super.onCreate(savedInstanceState);
        ImageUtils.initDefaultProfileImage(this); //TODO: remove. for debugging purposes only
    }

    private void initCourseDetailsRecyclerView(CompoRecyclerViewBinding binding) {
        adapter = new CourseDetailsAdapter(this, presenter.getCourseGroups(), this, this); //activity is both context and interfaces passed to adapter
        adapter.setHeader(CourseDetailsModel.getInstance().getCourse()); //Course data is passed to header
        adapter.setItems(CourseDetailsModel.getInstance().getGroups());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
    }

    //Add new group to members list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
            presenter.addGroupToCourseGroupsList(group);
            presenter.addCourseToGroupCourses(group);
            Log.d(TAG, "Group selected: " + group.toString());
        }
    }

    @Override
    public void onActionGroupClicked(ActionGroup group) {
        EventBus.getDefault().postSticky(group);
        String courseId = presenter.getCourseId();
        Course groupCourse = group.getCourses().get(courseId);
        EventBus.getDefault().postSticky(groupCourse); //Get this group's' course by its id
        Class courseStateActivity = groupCourse.getCourseStateActivity().getActivityClass();
        ActivityStarter.startActivity(this, courseStateActivity);
    }

    @Override
    public void onAddEntityVHClicked() {
        ActivityStarter.startActivityForResult(this, GroupListActivityForResult.class);
    }
}