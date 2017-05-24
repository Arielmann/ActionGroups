package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

public class CourseDetailsPresenterImpl implements CourseDetailsPresenter {

    private final GenericRecyclerViewInterface iRecyclerView;
    private Course course;
    private CourseDetailsModel model;

    public CourseDetailsPresenterImpl(GenericRecyclerViewInterface iRecyclerView, Course course) {
        this.model = CourseDetailsModel.getInstance();
        this.course = course;
        this.iRecyclerView = iRecyclerView;
    }

    @Override
    public void addGroupToCourseGroupsList(ActionGroup group) {
        List<ActionGroup> dataSet = CourseDetailsModel.getInstance().getGroups();
        dataSet.add(group);
        iRecyclerView.refreshAdapter();
    }

    /*
    Course reference was sent from CourseDetailsActivity. This
    object SHOULD NOT be mutated by it's associated groups.
    therefore we create a copy in this method below:
    */
    @Override
    public void addCourseToGroupCourses(ActionGroup group) {
        Course courseCopy = new Course(course);
        group.getCourses().put(course.getObjectId(), courseCopy);
    }

    private void initDummyDataSet() {
        if (model.getGroups().size() == 0) {
            for (int i = 0; i < 3; i++) {
                ActionGroup group = new ActionGroup();
                Course courseCopy = new Course(course); //put unique copy of this course for the group under the common course id
                group.getCourses().put(courseCopy.getObjectId(), courseCopy);
                model.getGroups().add(group);
            }
        }
    }

    @Override
    public void updateModelData() {
        model.setCourse(course);
        initDummyDataSet();
    }

    @Override
    public String getCourseId() {
        return model.getCourse().getObjectId();
    }
}