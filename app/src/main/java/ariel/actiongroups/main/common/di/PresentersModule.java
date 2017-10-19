package ariel.actiongroups.main.common.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.coursedetails.presenter.CourseDetailsPresenter;
import ariel.actiongroups.main.common.courses.coursedetails.presenter.CourseDetailsPresenterImpl;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenter;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenterImpl;
import ariel.actiongroups.main.common.login.presenter.LoginPresenter;
import ariel.actiongroups.main.common.login.presenter.LoginPresenterImpl;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenter;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenterImpl;
import ariel.actiongroups.main.leader.groups.creator.view.GroupCreatorActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Singleton
    @Provides
    LoginPresenter provideLoginActivityPresenter(ActionGroupsApplication application){
        return new LoginPresenterImpl(application.getAppComponent());
    }

    @Singleton
    @Provides
    GroupCreatorPresenter provideGroupCreatorPresenter(ActionGroupsApplication application){
        return new GroupCreatorPresenterImpl(application.getAppComponent());
    }


    @Singleton
    @Provides
    GatherPaymentPresenter provideGatherPaymentPresenter(ActionGroupsApplication application){
        return new GatherPaymentPresenterImpl(application.getAppComponent());
    }
}
