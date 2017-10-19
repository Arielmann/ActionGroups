package ariel.actiongroups.main.common.di;


import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenterImpl;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentActivity;
import ariel.actiongroups.main.leader.groups.services.GroupUploadService;
import ariel.actiongroups.main.leader.groups.services.RegisterGroupToCourseService;
import ariel.actiongroups.main.leader.groups.services.RegisterUserToGroupService;
import ariel.actiongroups.main.common.login.presenter.LoginPresenterImpl;
import ariel.actiongroups.main.common.login.view.LoginActivity;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.presenter.CourseDesignerPresenterImpl;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.services.CourseUploadService;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenterImpl;
import dagger.Component;

@Component(modules={AppModule.class, NetworkModule.class, PresentersModule.class})
@Singleton
public interface AppComponent {
    void inject(LoginPresenterImpl presenter);
    void inject(GroupCreatorPresenterImpl presenter);
    void inject(CourseSearchViewPresenterImpl presenter);
    void inject(CourseUploadService courseUploadService);
    void inject(RegisterUserToGroupService registerUserToGroupService);
    void inject(LoginActivity loginActivity);
    void inject(GatherPaymentActivity gatherPaymentActivity);
    void inject(CourseDesignerPresenterImpl courseManagerPresenter);
    void inject(GatherPaymentPresenterImpl gatherPaymentPresenter);
    void inject(RegisterGroupToCourseService registerGroupToCourseService);
    void inject(GroupUploadService groupUploadService);
}
