package ariel.actiongroups.main.common.app;

import android.app.Application;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.Random;

import ariel.actiongroups.main.common.app.appinit.AppInit;
import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.di.AppModule;
import ariel.actiongroups.main.common.di.DaggerAppComponent;
import ariel.actiongroups.main.common.di.NetworkModule;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.users.models.User;
import ariel.actiongroups.main.common.utils.datamanager.DataManager;

public class ActionGroupsApplication extends Application {

    private static final String TAG = ActionGroupsApplication.class.getSimpleName();
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .networkModule(new NetworkModule()).build();
        AppInit.InitApp(this);
       //registerDummyUser();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void registerDummyUser() {
        Random rand = new Random();
        BackendlessUser user = new User();
        user.setProperty(AppStrings.NAME, "Ariel" + rand.nextInt(1000-2) + 2);
        user.setProperty(AppStrings.DESCRIPTION, "I am a nice user");
        user.setEmail("arielmann" +  rand.nextInt(1000-2) + 2 + "@gmail.com");
        user.setPassword("iAmWatchingU");

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            public void handleResponse(BackendlessUser registeredUser) {
                DataManager.getInstance().setUser(registeredUser);
            }

            public void handleFault(BackendlessFault fault) {
                Log.e(TAG, "User registration error: " + fault.getCode());
            }
        });
    }
}
