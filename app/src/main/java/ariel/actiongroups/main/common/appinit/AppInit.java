package ariel.actiongroups.main.common.appinit;

import android.app.Activity;
import android.content.res.Resources;

import com.backendless.Backendless;

import ariel.actiongroups.R;

public class AppInit {

    public static void InitApp(Activity activity){
        Resources res = activity.getResources();
        Backendless.initApp( activity, res.getString(R.string.backendless_app_id), res.getString(R.string.backendless_secret_key),  res.getString(R.string.app_version));
    }
}
