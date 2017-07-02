package ariel.actiongroups.main.common.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.profiles.sharedprefrences.SharedPrefManager;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private ActionGroupsApplication application;

    public AppModule(ActionGroupsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton //Also being provided to other modules
    ActionGroupsApplication providesApplication() {
        return application;
    }

    @Singleton
    @Provides
    SharedPrefManager provideSharedPrefrencesManager(){
        return SharedPrefManager.getInstance(application);
    }
}
