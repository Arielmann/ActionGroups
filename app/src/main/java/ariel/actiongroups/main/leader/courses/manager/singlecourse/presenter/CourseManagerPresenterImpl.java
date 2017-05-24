package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import android.util.Log;

import com.algolia.search.saas.Client;
import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.di.SearchComponent;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.view.CourseManagerView;

public class CourseManagerPresenterImpl implements CourseManagerPresenter {

    private static final String TAG = CourseSearchViewPresenterImpl.class.getSimpleName();

    @Inject
    Client searchEngineClient;
    @Inject
    Gson gson;

    private CourseManagerView view;
    private List<Map> savedChallengesMaps;

    public CourseManagerPresenterImpl(SearchComponent searchComponent, CourseManagerView view) {
        this.view = view;
        searchComponent.inject(this);
        savedChallengesMaps = new ArrayList<>();
    }

    @Override
    public void removeCard(Challenge challenge) {
        view.refreshAdapter();
    }

    @Override
    public void addCard(Challenge challenge) {
        List<Challenge> dataSet = CourseManagerModel.getInstance().getChallenges();
        dataSet.add(challenge);
        view.refreshAdapter();
    }

    @Override
    public void initDummyChallenges(List<Challenge> challenges) {
        for (int i = 0; i < 10; i++) {
            Challenge challenge = new Challenge(i);
            challenge.setName("Challenge " + i);
            challenge.setDescription("Challenge " + i);
            challenges.add(challenge);
        }
    }

    @Override
    public void setChallenges(List<Challenge> challenges) {
        CourseManagerModel.getInstance().setChallenges(challenges);
    }

    public void saveCourseToDataBases(Course course) throws JSONException {
        uploadCourseToBackendlessDB(course);
        uploadCourseToSearchEngine(course);
    }

    private void uploadCourseToBackendlessDB(final Course course) {
        final IDataStore<Map> coursesStorage = Backendless.Data.of(AppStrings.BACKENDLESS_COURSES);
        Map<String, Object> courseMap = new HashMap<>();
        courseMap.put(AppStrings.NAME, course.getName());
        courseMap.put(AppStrings.DESCRIPTION, course.getDescription());
        courseMap.put(AppStrings.STATE, course.getCourseStateName());
        Backendless.Persistence.of(AppStrings.BACKENDLESS_COURSES).save(courseMap, new AsyncCallback<Map>() {
            @Override
            public void handleResponse(Map response) {
                if (response != null) {
                    Log.d(TAG, "Course named + " + course.getName() + " was succesfully uploaded. details: " + response.toString());
                    if (course.getChallenges().get(0) != null) {
                        uploadCourseChallengesToServer(response, course, course.getChallenges().get(0));
                    } else {
                        Log.d(TAG, "Course named" + course.getName() + "challenges array is empty");
                        view.popNoChallengesCreatedError();
                    }
                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    private void uploadCourseChallengesToServer(final Map savedCourseNotFullyInitializedMap, final Course course, final Challenge challenge) {
        final IDataStore<Map> challengesStorage = Backendless.Data.of(AppStrings.BACKENDLESS_CHALLENGES);
        final IDataStore<Map> leadersStorage = Backendless.Data.of(AppStrings.BACKENDLESS_LEADERS);
        final IDataStore<Map> coursesStorage = Backendless.Data.of(AppStrings.BACKENDLESS_COURSES);

        Map<String, Object> challengeMap = new HashMap<>();
        challengeMap.put(AppStrings.NAME, challenge.getName());
        challengeMap.put(AppStrings.DESCRIPTION, challenge.getDescription());
        Backendless.Persistence.of(AppStrings.BACKENDLESS_CHALLENGES).save(challengeMap, new AsyncCallback<Map>() {


            @Override
            public void handleResponse(Map response) {
                savedChallengesMaps.add(response);
                try {
                    uploadCourseChallengesToServer(savedCourseNotFullyInitializedMap, course, course.getChallenges().get(challenge.getPositionInCourse() + 1));
                } catch (IndexOutOfBoundsException ignored) {
                    if (course.getChallenges().size() == savedChallengesMaps.size()) {
                        coursesStorage.setRelation(savedCourseNotFullyInitializedMap, AppStrings.CHALLENGES + ":" + AppStrings.BACKENDLESS_COURSES + ":n", savedChallengesMaps, new AsyncCallback<Integer>() {
                            @Override
                            public void handleResponse(Integer response) {
                                if (response != null) {
                                    Log.d(TAG, "Relation was succefully created between course named + " + course.getName() + " and challenge named " + challenge.getName());
                                    // if(course.getChallenges().get(challenge.getPositionInCourse() + 1) != null ) {

                                }
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {

                            }
                        });
                    } else {
                        Log.e(TAG, "Not all challenges were uploaded, Relation was not created");
                    }
                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    private void uploadCourseToSearchEngine(Course course) {
          /*    Index index = searchEngineClient.getIndex(AppStrings.ALGOLIA_COURSES_TABLE_NAME);
        index.addObjectAsync(new JSONObject()
                        .put(AppStrings.ID, course.getObjectId())
                        .put(AppStrings.NAME, course.getName())
                        .put(AppStrings.LEADER_NAME, course.getLeader().getName())
                        .put(AppStrings.LEADER_ID, course.getLeader().getObjectId())
                        .put(AppStrings.DESCRIPTION, course.getDescription())
                        .put(AppStrings.IMAGE_URL, ImageUtils.testImagePath)
                        .put(AppStrings.CREATION_DATE, course.getCreationDate()), null);*/
    }
}
