package ariel.actiongroups.main.common.backend;

import android.content.Context;

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
    }

    public interface RegisterUserDelegate {
        void registerNewUser(BackendlessUser user);
    }

    public interface RegisterLeaderDelegate {
        void registerNewLeader(Context context, User leader);
    }

    public interface RegisterObjectDelegate {
        void registerNewObject(String tableName);
    }
}
