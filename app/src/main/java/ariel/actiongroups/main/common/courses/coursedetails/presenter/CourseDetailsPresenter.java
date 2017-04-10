package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import java.util.List;

import ariel.actiongroups.main.common.groups.ActionGroup;

public interface CourseDetailsPresenter {

    void addGroupToCourseGroupsList(ActionGroup group);
    void addCourseToGroupCourses(ActionGroup group);
    void updateModelData();
    String getCourseId();
}
