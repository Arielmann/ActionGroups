package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import ariel.actiongroups.main.leader.groups.ActionGroup;

public interface CourseDetailsPresenter {

    void addGroupToCourseGroupsList(ActionGroup group);
    void addCourseToGroupCourses(ActionGroup group);
    void updateModelData();
    String getCourseId();
}
