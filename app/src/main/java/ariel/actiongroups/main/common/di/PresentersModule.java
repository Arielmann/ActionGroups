package ariel.actiongroups.main.common.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenter;
import ariel.actiongroups.main.common.courses.states.gatherpayment.presenter.GatherPaymentPresenterImpl;
import ariel.actiongroups.main.common.login.presenter.LoginPresenter;
import ariel.actiongroups.main.common.login.presenter.LoginPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Singleton
    @Provides
    LoginPresenter provideLoginActivityPresenter(ActionGroupsApplication application){
        return new LoginPresenterImpl(application.getAppComponent());
    }
}
