package ariel.actiongroups.main.common.courses.coursedetails.model;

import android.util.Log;

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

    public void initDummyDataSet(){
        for(int i=0; i < 3; i++){
            ActionGroup group = new ActionGroup();
            group.getCourses().put(course.getId(), course);
            groups.add(group);
        }
    }

    public static CourseDetailsModel getInstance() {
        if(model == null) {
            model = new CourseDetailsModel();
        }
        return model;
    }

    public Course getCourse() {
        if(course == null){
            Log.wtf(TAG, "setCourse() was probably not yet called. Allowing application crash");
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
