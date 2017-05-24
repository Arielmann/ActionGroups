package ariel.actiongroups.main.common.utils.backendutils.backendlesshelperdi;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.utils.backendutils.BackendlessHelper;
import dagger.Module;
import dagger.Provides;

@Module
class BackendlessModule {

    @Singleton
    @Provides
    BackendlessHelper provideBackendlessHelper(){
        return BackendlessHelper.getInstance();
    }
}
