package ariel.actiongroups.main.common.utils.backendutils.backebdless.di.helper;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.utils.backendutils.backebdless.BackendlessHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class BlHelperModule {

    @Singleton
    @Provides
    BackendlessHelper provideBackendlessHelper(){
        return BackendlessHelper.getInstance();
    }
}
