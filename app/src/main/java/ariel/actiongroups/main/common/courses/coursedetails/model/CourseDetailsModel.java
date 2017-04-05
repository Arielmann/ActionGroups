package ariel.actiongroups.main.common.courses.coursedetails.model;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;

public class CourseDetailsModel {

    private static final String TAG = CourseDetailsModel.class.getSimpleName();
    private static CourseDetailsModel model;
    private List<ActionGroup> groups;
    private Course course;

    private CourseDetailsModel() {
        groups = new ArrayList<>();
    }

    public static CourseDetailsModel getInstance() {
        if(model == null) {
            model = new CourseDetailsModel();
        }
        return model;
    }

    public Course getCourse() {
        if(course == null){
           throw new NullPointerException("Course is null. setCourse() was probably not yet called. Application crashes");
        }
        return course;
    }

    public List<ActionGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ActionGroup> groups) {
        this.groups = groups;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
