package ariel.actiongroups.main.common.utils.backendutils.backebdless;

import android.content.Context;
import android.graphics.Bitmap;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.users.models.User;

public abstract class BackendlessHelperDelegations {

    public interface RegisterChallengeDelegate {
        void registerNewChallenge(Context context, Challenge challenge);
    }

    public interface RegisterGroupDelegate {
        void registerNewGroup(Context context, ActionGroup group);
        void registerToPushNotificationsCustomChannel(String channel);
    }

    public interface RegisterUserDelegate {
        void registerToPushNotificationsDefaultChannel();
        void registerNewUser(User user);
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
