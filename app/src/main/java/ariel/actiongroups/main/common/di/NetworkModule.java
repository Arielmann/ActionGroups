package ariel.actiongroups.main.common.di;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.persistence.DataQueryBuilder;
import com.facebook.CallbackManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.backendutils.NetworkHelper;
import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {



    public NetworkModule() {

    }

    @Singleton
    @Provides
    BackendlessHelper provideBackendlessHelper() {
        return BackendlessHelper.getInstance();
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_TABLE_COURSE)
    IDataStore<Course> provideCourseStorage() {
        return Backendless.Data.of(Course.class);
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_TABLE_ACTION_GROUPS)
    IDataStore<ActionGroup> provideActionGroups() {
        return Backendless.Data.of(ActionGroup.class);
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_TABLE_CHALLENGES)
    IDataStore<User> provideChallngesStorage() {
        return Backendless.Data.of(User.class);
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_TABLE_LEADERS)
    IDataStore<Map> provideLeadersStorage() {
        return Backendless.Data.of(AppStrings.BACKENDLESS_TABLE_LEADERS);
    }

    @Singleton
    @Provides
    DataQueryBuilder provideDataQueryBuilder() {
        return DataQueryBuilder.create();
    }

    @Singleton
    @Provides
    CallbackManager provideFbCallbackManager() {
        return CallbackManager.Factory.create();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    NetworkHelper provideNetworkHelper() {
        return NetworkHelper.getInstance();
    }
}
