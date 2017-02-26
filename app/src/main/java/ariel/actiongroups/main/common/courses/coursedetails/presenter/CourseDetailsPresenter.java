package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;

public interface CourseDetailsPresenter {

    void addGroupToCourseGroupsList(ActionGroup group);
    void addCourseToGroupCourses(ActionGroup group, Course course);
}
