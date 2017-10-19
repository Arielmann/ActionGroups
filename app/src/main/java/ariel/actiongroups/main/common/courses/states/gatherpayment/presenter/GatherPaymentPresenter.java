package ariel.actiongroups.main.common.courses.states.gatherpayment.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentView;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.presenterutils.GenericPresenter;

public interface GatherPaymentPresenter extends GenericPresenter {

    void registerGroupToCourseInServer(Context context, Course course, ActionGroup group);
    void setView(GatherPaymentView view);
}
