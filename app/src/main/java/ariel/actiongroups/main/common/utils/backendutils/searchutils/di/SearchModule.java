package ariel.actiongroups.main.common.utils.backendutils.searchutils.di;

import com.algolia.search.saas.Client;
import com.algolia.search.saas.Index;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import ariel.actiongroups.main.common.resources.AppStrings;
import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

   private Client client;

    public SearchModule() {
        client = new Client(AppStrings.ALOGLIA_APP_ID, AppStrings.ALOGLIA_ADMIN_API_KEY);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    @Named(AppStrings.ALGOLIA_COURSES_TABLE_NAME)
    Index provideCoursesIndex() {
        return client.getIndex(AppStrings.ALGOLIA_COURSES_TABLE_NAME);
    }
}
