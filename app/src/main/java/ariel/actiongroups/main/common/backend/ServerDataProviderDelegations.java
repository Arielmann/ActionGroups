package ariel.actiongroups.main.common.backend;

import android.content.Context;
import android.graphics.Bitmap;

import com.backendless.BackendlessUser;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.groups.model.ActionGroup;
import ariel.actiongroups.main.common.profiles.models.User;

public abstract class ServerDataProviderDelegations {

    public interface RegisterChallengeDelegate {
        void registerNewChallenge(Context context, Challenge challenge);
    }

    public interface RegisterGroupDelegate {
        void registerNewGroup(Context context, ActionGroup group);
        void registerToPushNotificationsCustomChannel(String channel);
    }

    public interface RegisterUserDelegate {
        void registerToPushNotificationsDefaultChannel();
        void registerNewUser(BackendlessUser user);
    }

    public interface RegisterLeaderDelegate {
        void registerNewLeader(Context context, User leader);
    }

    public interface RegisterObjectDelegate {
        void registerNewObject(String tableName);
    }

    public interface FileUploadDelegate{
        void uploadImage(Context context, Bitmap image);
    }
}
