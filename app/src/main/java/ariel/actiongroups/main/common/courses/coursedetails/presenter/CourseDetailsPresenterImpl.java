package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import java.util.List;

import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.abstractutils.GenericRecyclerViewInterface;

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
}
