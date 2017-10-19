package ariel.actiongroups.main.common.courses.coursedetails.presenter;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

import static org.mockito.Mockito.mock;

public class CourseDetailsPresenterImplTest {

    private static CourseDetailsPresenterImpl presenter;

    @BeforeClass
    public static void setUp(){
        GenericRecyclerViewInterface iRecyclerView = mock(GenericRecyclerViewInterface.class);
        presenter = new CourseDetailsPresenterImpl(iRecyclerView, mock(Course.class));
    }

    @Test
    public void testAddGroupToCourseGroupsList(){
        ActionGroup group = mock(ActionGroup.class);
        presenter.addGroupToCourseGroupsList(group);
        Assert.assertEquals(CourseDetailsModel.getInstance().getGroups().size(), 1);
    }
}