package ariel.actiongroups.main.common.utils.backendutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkHelper {

    public static final String NO_NETWORK_MSG = "Network Not Available";

    public static boolean hasNetworkAccess(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }catch(Exception e){
            return false;
        }

    }

}
