package ariel.actiongroups.main.common.utils.backendutils.searchutils.di;

import com.algolia.search.saas.Client;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.backendutils.BackendlessHelper;
import dagger.Module;
import dagger.Provides;

@Module
class SearchModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Client provideSearchEngineClient() {
        return new Client(AppStrings.ALOGLIA_APP_ID, AppStrings.ALOGLIA_ADMIN_API_KEY);
    }


}
