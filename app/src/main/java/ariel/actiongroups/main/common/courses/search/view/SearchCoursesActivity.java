package ariel.actiongroups.main.common.courses.search.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivitySearchCoursesBinding;
import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.OnCourseClicked;
import ariel.actiongroups.main.common.courses.courselandpage.CourseLandPageActivity;
import ariel.actiongroups.main.common.courses.search.adapter.CourseSearchResultsAdapter;
import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenter;
import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.OnSearchViewClicked;

public class SearchCoursesActivity extends AppCompatActivity implements OnSearchViewClicked, OnCourseClicked, SearchCourseView{

    private CourseSearchViewPresenter presenter;
    private CourseSearchResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CourseSearchViewPresenterImpl(((ActionGroupsApplication) getApplication()).getAppComponent(), this);
        adapter = new CourseSearchResultsAdapter(this, new ArrayList<Course>(), this);
        ActivitySearchCoursesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search_courses);
        RecyclerView recyclerView = binding.searchCourseResultsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSearchViewClicked(String query) {
        presenter.fetchCourses(query);
    }

    @Override
    public void updateCoursesSerachResults(List<Course> coursesList) {
        adapter.setDataSet(coursesList);
    }

    @Override
    public void popNoResultsMessage() {
        Toast.makeText(this, "No courses found",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void onCourseClicked(Course course) {
        EventBus.getDefault().postSticky(course);
        ActivityStarter.startActivity(this, CourseLandPageActivity.class);
    }
}
