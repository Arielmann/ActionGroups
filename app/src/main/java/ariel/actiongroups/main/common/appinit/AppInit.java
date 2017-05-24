package ariel.actiongroups.main.common.appinit;

import com.backendless.Backendless;

import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class AppInit {

    public static void InitApp(ActionGroupsApplication application){
        Backendless.initApp( application, AppStrings.BACKENDLESS_APP_ID, AppStrings.BACKENDLESS_API_KEY);
        ImageUtils.initDefaultProfileImage(application);
    }
}
