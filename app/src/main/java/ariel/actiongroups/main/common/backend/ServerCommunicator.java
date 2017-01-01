package ariel.actiongroups.main.common.backend;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.HashMap;
import java.util.Map;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.groups.model.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.User;
import ariel.actiongroups.main.common.profiles.sharedprefrences.SharedPrefManager;

public class ServerCommunicator implements ServerDataProviderDelegations.RegisterChallengeDelegate, ServerDataProviderDelegations.RegisterGroupDelegate, ServerDataProviderDelegations.RegisterUserDelegate, ServerDataProviderDelegations.RegisterLeaderDelegate {
    private static ServerCommunicator dataSaver;
    private String TAG = ServerCommunicator.class.getName();

    public static ServerCommunicator getInstance() {
        if (dataSaver == null) {
            dataSaver = new ServerCommunicator();
        }
        return dataSaver;
    }

    private ServerCommunicator() {
    }

    @Override
    public void registerNewChallenge(Context context, Challenge challenge) {
        Resources res = context.getResources();
        String challengesTableName = res.getString(R.string.challenges);
        Map<String, Object> challengeMap = new HashMap();
        challengeMap.put(res.getString(R.string.name), challenge.getChallengeName());
        challengeMap.put(res.getString(R.string.description), challenge.getDescription());
        saveMapToServer(challengesTableName, challengeMap);
    }

    @Override
    public void registerNewGroup(Context context, ActionGroup group) {
        Resources res = context.getResources();
        Map<String, Object> groupMap = new HashMap();
        groupMap.put(res.getString(R.string.name), group.getName());
        groupMap.put(res.getString(R.string.description), group.getDescription());
        String groupsTableName = res.getString(R.string.groups);
        saveMapToServer(groupsTableName, groupMap);
    }

    @Override
    public void registerNewUser(BackendlessUser user) {
        user.setEmail("arielmann2@gmail.com");
        user.setPassword("1234567890");

        Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.i(TAG, backendlessUser.getEmail() + " successfully registered");
            }
        });
    }

    @Override
    public void registerNewLeader(Context context, User leader) {
        Resources res = context.getResources();
        String leaderTableName = res.getString(R.string.leaders);
        Map<String, Object> leaderMap = new HashMap<>();
        leaderMap.put(res.getString(R.string.name), SharedPrefManager.getInstance(context).getUserName());
        leaderMap.put(res.getString(R.string.password), SharedPrefManager.getInstance(context).getUserPassword());
        //leader.put(res.getString(R.string.email), SharedPrefManager.getInstance(context).getUserEmail());
        saveMapToServer(leaderTableName, leaderMap);
    }


    private void saveMapToServer(String tableName, Map objectMap) {
        // save object asynchronously
        Backendless.Persistence.of(tableName).save(objectMap, new AsyncCallback<Map>() {
            public void handleResponse(Map response) {
                // new Contact instance has been saved
            }

            public void handleFault(BackendlessFault fault) {
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });
    }
}

