package ariel.actiongroups.main.common.courses.search.view;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;

public interface SearchCourseView {

    void updateCoursesSerachResults(List<Course> coursesList);

    void popNoResultsMessage();
}
