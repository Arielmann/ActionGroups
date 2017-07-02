package ariel.actiongroups.main.common.utils.backendutils.backebdless.di.storages;

import com.backendless.Backendless;
import com.backendless.IDataStore;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import ariel.actiongroups.main.common.resources.AppStrings;
import dagger.Module;
import dagger.Provides;

@Module
public class BlStoragesModule {

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_COURSES)
    IDataStore<Map> provideCourseStorage() {
        return Backendless.Data.of(AppStrings.BACKENDLESS_COURSES);
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_CHALLENGES)
    IDataStore<Map> provideChallngesStorage() {
        return Backendless.Data.of(AppStrings.BACKENDLESS_CHALLENGES);
    }

    @Singleton
    @Provides
    @Named(AppStrings.BACKENDLESS_LEADERS)
    IDataStore<Map> provideLeadersStorage() {
        return Backendless.Data.of(AppStrings.BACKENDLESS_LEADERS);
    }
}
