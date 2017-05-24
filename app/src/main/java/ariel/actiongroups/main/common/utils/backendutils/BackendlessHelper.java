package ariel.actiongroups.main.common.utils.backendutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.files.BackendlessFile;

import java.util.HashMap;
import java.util.Map;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.User;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

//TODO: make abstract, remove singleton and Seperate to different classes
public class BackendlessHelper implements BackendlessHelperDelegations.RegisterChallengeDelegate, BackendlessHelperDelegations.RegisterGroupDelegate, BackendlessHelperDelegations.RegisterUserDelegate, BackendlessHelperDelegations.RegisterLeaderDelegate, BackendlessHelperDelegations.FileUploadDelegate {
    private static BackendlessHelper backendlessHelper;
    private String TAG = BackendlessHelper.class.getName();

    public static BackendlessHelper getInstance() {
        if (backendlessHelper == null) {
            backendlessHelper = new BackendlessHelper();
        }
        return backendlessHelper;
    }

    private BackendlessHelper() {
    }

    @Override
    public void registerNewChallenge(Context context, Challenge challenge) {
        if(NetworkHelper.hasNetworkAccess(context)) {
            String challengesTableName = AppStrings.UPPER_CASE_CHALLENGES;
            Map<String, Object> challengeMap = new HashMap();
            challengeMap.put(AppStrings.UPPER_CASE_NAME, challenge.getName());
            challengeMap.put(AppStrings.UPPER_CASE_DESCRIPTION, challenge.getDescription());
            saveMapToServer(challengesTableName, challengeMap);
        }else{
            Toast.makeText(context, NetworkHelper.NO_NETWORK_MSG, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void registerNewGroup(Context context, ActionGroup group) {
        Resources res = context.getResources();
        Map<String, Object> groupMap = new HashMap();
        groupMap.put(res.getString(R.string.name), group.getName());
        groupMap.put(res.getString(R.string.description), group.getDescription());
        String groupsTableName = res.getString(R.string.groups);
        saveMapToServer(groupsTableName, groupMap);
        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.female_icon);
        uploadImage(context, image);
    }

    @Override
    public void registerToPushNotificationsDefaultChannel() {
        Backendless.Messaging.registerDevice(AppStrings.BACKENDLESS_SENDER_ID);
    }

    @Override
    public void registerToPushNotificationsCustomChannel(final String channel) {
        new Thread(new Runnable() {
            public void run() {
                Backendless.Messaging.registerDevice(AppStrings.BACKENDLESS_SENDER_ID, channel);
            }
        }).start();
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
        //leaderMap.put(res.getString(R.string.name), SharedPrefManager.getInstance(context).getUserName());
        //leaderMap.put(res.getString(R.string.password), SharedPrefManager.getInstance(context).getUserPassword());
        saveMapToServer(leaderTableName, leaderMap);
    }


    public void saveMapToServer(String tableName, Map objectMap) {
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

    @Override
    public void uploadImage(final Context context, Bitmap image) {

        Backendless.Files.Android.upload( image, Bitmap.CompressFormat.PNG, 100, "myphoto.png", "mypics", true,
                new AsyncCallback<BackendlessFile>()
                {
                    @Override
                    public void handleResponse( final BackendlessFile backendlessFile )
                    {
                        Log.d(TAG, "Upload successful, image url: " + backendlessFile.getFileURL());
                        ImageUtils.downloadChatImage(context, null, "me", backendlessFile.getFileURL());
                    }

                    @Override
                    public void handleFault( BackendlessFault backendlessFault )
                    {
                        Log.e(TAG, "Image upload failed. Error: " + backendlessFault.toString());
                    }
                });
    }
}

