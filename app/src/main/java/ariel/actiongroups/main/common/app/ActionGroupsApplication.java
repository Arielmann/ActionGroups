package ariel.actiongroups.main.common.app;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import ariel.actiongroups.main.common.appinit.AppInit;
import ariel.actiongroups.main.common.utils.backendutils.backendlesshelperdi.BackendlessComponent;
import ariel.actiongroups.main.common.utils.backendutils.backendlesshelperdi.DaggerBackendlessComponent;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.di.DaggerSearchComponent;
import ariel.actiongroups.main.common.utils.backendutils.searchutils.di.SearchComponent;

public class ActionGroupsApplication extends Application {

    private BackendlessComponent blComponent;
    private SearchComponent searchComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        blComponent = DaggerBackendlessComponent.create();
        searchComponent = DaggerSearchComponent.create();
        AppInit.InitApp(this);
    }

    public BackendlessComponent getBlComponent() {
        return blComponent;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
}
