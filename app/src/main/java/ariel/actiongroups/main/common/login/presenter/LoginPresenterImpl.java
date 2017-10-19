package ariel.actiongroups.main.common.login.presenter;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import javax.inject.Inject;

import ariel.actiongroups.main.common.di.AppComponent;
import ariel.actiongroups.main.common.users.sharedprefrences.SharedPrefManager;
import ariel.actiongroups.main.common.resources.AppStrings;

public class LoginPresenterImpl implements LoginPresenter {

    @Inject
    protected SharedPrefManager sharedPrefManager;

    public LoginPresenterImpl(AppComponent component) {
        component.inject(this);
    }

    @Override
    public void dummyRegisterUser() {
        BackendlessUser user = new BackendlessUser();
        user.setProperty(AppStrings.NAME, "Ariel");
        user.setEmail("ArielMann2@gmail.com");
        user.setPassword("123456");

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                sharedPrefManager.saveStringInfoToSharedPreferences(SharedPrefManager.SharedPrefrencesProperty.ID, response.getUserId());
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }
}
