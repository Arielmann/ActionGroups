package ariel.actiongroups.main.common.app.appinit;

import com.backendless.Backendless;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class AppInit {

    public static void InitApp(ActionGroupsApplication application){
        Backendless.initApp( application, AppStrings.BACKENDLESS_APP_ID, AppStrings.BACKENDLESS_API_KEY);
        FacebookSdk.setApplicationId(AppStrings.FACEBOOK_APP_ID);
        FacebookSdk.sdkInitialize(application);
        AppEventsLogger.activateApp(application);
        ImageUtils.initDefaultProfileImage(application);
    }
}
