package ariel.actiongroups.main.leader.courses.manager.singlecourse.view;

import android.content.Context;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

public interface CourseManagerView extends GenericRecyclerViewInterface {

    void popNoChallengesCreatedError();
    void goToNextScreen();
    Context getcontext();

}
