package ariel.actiongroups.main.common.backend;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.model.Challenge;
import ariel.actiongroups.main.common.groups.model.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.User;
import ariel.actiongroups.main.common.utils.SharedPrefrences.SharedPrefManager;

public class ServerDataSaver {
    private static ServerDataSaver dataSaver;
    private static Resources res;
    private String TAG = ServerDataSaver.class.getName();

    public static ServerDataSaver getInstance(Context context) {
        if (dataSaver == null) {
            res = context.getResources();
            dataSaver = new ServerDataSaver();
        }
        return dataSaver;
    }

    private ServerDataSaver() {
    }

    public void registerNewUser(Context context) {
        BackendlessUser user = new BackendlessUser();
        user.setEmail("arielmann2@gmail.com");
        user.setPassword("1234567890");

        Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.i(TAG, backendlessUser.getEmail() + " successfully registered");
            }
        });
    }

    public void registernewLeader(Context context) {
        Map user = new HashMap();
        user.put(res.getString(R.string.name), SharedPrefManager.getInstance(context).getUserName());
        user.put(res.getString(R.string.password), SharedPrefManager.getInstance(context).getUserPassword());
        //user.put(res.getString(R.string.email), SharedPrefManager.getInstance(context).getUserEmail());

        // save object synchronously
        Map savedUser = Backendless.Persistence.of(res.getString(R.string.name)).save(user);
    }

    public void registerNewGroup(Context context, ActionGroup group) {
        Resources res = context.getResources();
        Map groupMap = new HashMap();
        groupMap.put(res.getString(R.string.name), group.getName());
        groupMap.put(res.getString(R.string.description), group.getDescription());

        // save object synchronously
        Map savesdGroup = Backendless.Persistence.of(res.getString(R.string.name)).save(groupMap);
    }

    public void registerNewChallenge(Context context, Challenge challenge) {
        Resources res = context.getResources();
        Map challengeMap = new HashMap();
        challengeMap.put(res.getString(R.string.name), challenge.getChallengeName());
        challengeMap.put(res.getString(R.string.description), challenge.getDescription());

        // save object synchronously
        Backendless.Persistence.of(res.getString(R.string.challenges)).save(challengeMap, new AsyncCallback<Map>() {
            public void handleResponse( Map response )
            {
                // new Contact instance has been saved
            }

            public void handleFault( BackendlessFault fault )
            {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });
    }
}

