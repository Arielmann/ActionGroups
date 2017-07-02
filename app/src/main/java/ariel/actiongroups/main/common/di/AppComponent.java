package ariel.actiongroups.main.common.di;


import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.common.courses.states.gatherpayment.services.RegisterUseToCourseService;
import ariel.actiongroups.main.common.courses.states.gatherpayment.view.GatherPaymentActivity;
import ariel.actiongroups.main.common.login.presenter.LoginPresenterImpl;
import ariel.actiongroups.main.common.login.view.LoginActivity;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.services.CourseUploadService;
import dagger.Component;

@Component(modules={AppModule.class, NetworkModule.class, PresentersModule.class})
@Singleton
public interface AppComponent {
    void inject(LoginPresenterImpl presenter);
    void inject(CourseSearchViewPresenterImpl presenter);
    void inject(CourseUploadService courseUploadService);
    void inject(LoginActivity loginActivity);
    void inject(RegisterUseToCourseService registerUserToServerInCourseService);
    void inject(GatherPaymentActivity gatherPaymentActivity);
    void inject(CourseManagerPresenterImpl courseManagerPresenter);
}
