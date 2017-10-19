package ariel.actiongroups.main.common.courses.states.challengenavigator.model;

import java.util.List;

import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.chat.ChatItem;

public abstract class ChallengeNavigatorModelDelegations {

    public interface ChallengeInfoDelegate {
        User getChallenge();
        void setChallenge(User challenge);
        Course getCourse();
    }

    public interface ResultDelegate {
        List<ChatItem> getChatItems();
        void setChatItems(List<ChatItem> chatItems);
    }

    public interface ChatDelegate {
       List<String> getResults();
    }

    public interface AllModelsDelegate {
        User getChallenge();
        void setChallenge(User challenge);
        List<ChatItem> getChatItems();
        void setChatItems(List<ChatItem> chatItems);
        List<String> getResults();
        void setCourse(Course course);
    }
}
