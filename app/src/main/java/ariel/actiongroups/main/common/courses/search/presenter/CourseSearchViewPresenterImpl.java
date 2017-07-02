package ariel.actiongroups.main.common.courses.search.presenter;

import android.util.Log;

import com.algolia.search.saas.AlgoliaException;
import com.algolia.search.saas.CompletionHandler;
import com.algolia.search.saas.Index;
import com.algolia.search.saas.Query;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.view.SearchCourseView;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.di.SearchComponent;

public class CourseSearchViewPresenterImpl implements CourseSearchViewPresenter {

    @Inject @Named(AppStrings.ALGOLIA_COURSES_TABLE_NAME)
    Index courseIndex;
    @Inject
    Gson gson;

    private static final String TAG = CourseSearchViewPresenterImpl.class.getSimpleName();
    private SearchCourseView view;

    public CourseSearchViewPresenterImpl(AppComponent component, SearchCourseView view) {
        component.inject(this);
        this.view = view;
    }

    @Override
    public void fetchCourses(String searchText) {
        courseIndex.searchAsync(new Query(searchText), new CompletionHandler() {
            @Override
            public void requestCompleted(JSONObject jsonObject, AlgoliaException e) {
                Log.d(TAG, "Search completed, results.toString(): " + jsonObject.toString());
                try {
                    //Map<String, Object> javaRootMapObject = new Gson().fromJson(jsonObject.toString(), Map.class);
                    List<Course> coursesSearchResult = gson.fromJson(jsonObject.optJSONArray(AppStrings.ALGOLIA_HITS).toString(), new TypeToken<List<Course>>() {
                    }.getType());
                    view.updateCoursesSerachResults(coursesSearchResult);
                } catch (IllegalStateException exception) {
                    exception.printStackTrace();
                    view.popNoResultsMessage();
                }
            }
        });
    }
}

