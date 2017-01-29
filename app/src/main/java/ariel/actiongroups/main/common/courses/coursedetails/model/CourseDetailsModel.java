package ariel.actiongroups.main.common.courses.coursedetails.model;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;

public class CourseDetailsModel {

    private static CourseDetailsModel model = new CourseDetailsModel();
    private List<ActionGroup> groups;
    private Course course;

    private CourseDetailsModel() {
    }

    public static CourseDetailsModel getInstance() {
        return model;
    }

    public Course getCourse() {
        return course;
    }

    public List<ActionGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ActionGroup> groups) {
        this.groups = groups;
    }
}
