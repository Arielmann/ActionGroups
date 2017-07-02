package ariel.actiongroups.main.common.courses.states.gatherpayment.presenter;

import android.content.Context;

import ariel.actiongroups.main.common.utils.presenterutils.GenericPresenter;

public interface GatherPaymentPresenter extends GenericPresenter {

    void registerUserToCourseInServer(Context context);
}
