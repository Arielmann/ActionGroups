package ariel.actiongroups.main.common.app;

import android.app.Application;

import com.backendless.BackendlessUser;

import ariel.actiongroups.main.common.appinit.AppInit;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.di.AppModule;
import ariel.actiongroups.main.common.di.DaggerAppComponent;
import ariel.actiongroups.main.common.di.NetworkModule;
import ariel.actiongroups.main.common.profiles.models.User;
import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelper;

public class ActionGroupsApplication extends Application {

    //private BlHelperComponent blHelperComponent;
    //private CourseUploadServiceComponent courseUploadServiceComponent;
    //private SearchComponent searchComponent;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
      //  blHelperComponent = DaggerBlHelperComponent.create();
      //  courseUploadServiceComponent = DaggerCourseUploadServiceComponent.create();
       // searchComponent = DaggerSearchComponent.create();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .networkModule(new NetworkModule()).build();
        AppInit.InitApp(this);

        BackendlessHelper helper = BackendlessHelper.getInstance();
        //helper.registerNewUser(new User());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
