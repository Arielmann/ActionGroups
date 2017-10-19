package ariel.actiongroups.main.common.utils.backendutils.backebdless;

import android.content.Context;
import android.graphics.Bitmap;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.leader.groups.ActionGroup;

public abstract class BackendlessHelperDelegations {

    public interface RegisterChallengeDelegate {
        void registerNewChallenge(Context context, User challenge);
    }

    public interface RegisterGroupDelegate {
        void registerNewGroup(Context context, ActionGroup group);
        void registerToPushNotificationsCustomChannel(String channel);
    }

    public interface RegisterUserDelegate {
        void registerToPushNotificationsDefaultChannel();
        void registerNewUser(ariel.actiongroups.main.common.users.models.User user);
    }

    public interface RegisterLeaderDelegate {
        void registerNewLeader(Context context, ariel.actiongroups.main.common.users.models.User leader);
    }

    public interface RegisterObjectDelegate {
        void registerNewObject(String tableName);
    }

    public interface FileUploadDelegate{
        void uploadImage(Context context, Bitmap image);
    }
}
