package ariel.actiongroups.main.common.courses.manager.coursedetails.model;

import java.util.List;

import ariel.actiongroups.main.common.groups.ActionGroup;

public class CourseDetailsModel {

    private static CourseDetailsModel model = new CourseDetailsModel();
    private List<ActionGroup> groups;

    public static CourseDetailsModel getInstance() {
        return model;
    }

    private CourseDetailsModel() {
    }

    public List<ActionGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ActionGroup> groups) {
        this.groups = groups;
    }
}
