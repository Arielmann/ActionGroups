package ariel.actiongroups.main.leader.courses.creator.singlecourse.events;

import ariel.actiongroups.main.common.courses.Course;

public class OnCourseUploadSuccess {

    private Course course;

    public OnCourseUploadSuccess(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
