package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.listutils.GenericRecyclerViewInterface;

public class CourseDetailsPresenterImpl implements CourseDetailsPresenter {

    private final GenericRecyclerViewInterface recyclerView;

    public CourseDetailsPresenterImpl(GenericRecyclerViewInterface recyclerView) {
        this.recyclerView = recyclerView;

    }

    @Override
    public void addGroupToCourseGroupsList(ActionGroup group) {
        List<ActionGroup> dataSet = CourseDetailsModel.getInstance().getGroups();
        dataSet.add(group);
        recyclerView.refreshAdapter();
    }

    /*
    Course reference was sent from CourseDetailsActivity. This
    object SHOULD NOT be mutated by it's associated groups.
    therefore we create a copy in below method:
    */
    @Override
    public void addCourseToGroupCourses(ActionGroup group, Course course) {
        Course courseCopy = course;
        group.getCourses().put(course.getId(), courseCopy);
    }
}
