package ariel.actiongroups.main.common.courses.search.presenter;

import android.util.Log;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.view.SearchCourseView;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.resources.AppStrings;

public class CourseSearchViewPresenterImpl implements CourseSearchViewPresenter {

    @Inject
    @Named(AppStrings.BACKENDLESS_TABLE_COURSE)
    IDataStore<Course> coursesStorage;

    @Inject
    DataQueryBuilder queryBuilder;

    private static final String TAG = CourseSearchViewPresenterImpl.class.getSimpleName();
    private SearchCourseView view;

    public CourseSearchViewPresenterImpl(AppComponent component, SearchCourseView view) {
        component.inject(this);
        this.view = view;
    }

    @Override
    public void fetchCourses(String searchText) {

        String whereClause = "name LIKE '" + searchText + "%'";
        queryBuilder.setWhereClause( whereClause );

        coursesStorage.find( queryBuilder,
                new AsyncCallback<List<Course>>(){
                    @Override
                    public void handleResponse( List<Course> foundCourses )
                    {
                        view.updateCoursesSerachResults(foundCourses);
                        if(foundCourses.size() == 0){
                            view.popNoResultsMessage();
                        }
                    }

                    @Override
                    public void handleFault( BackendlessFault fault )
                    {
                        Log.e(TAG, "Search error: " + fault.getCode());
                        view.popNoResultsMessage(); //TODO: Switch to error message
                    }
                });
    }
}

