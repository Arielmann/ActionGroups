package ariel.actiongroups.main.common.challenges.challenge_navigator.model;

import java.util.List;

import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.chat.ChatItem;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.profiles.models.User;

import static ariel.actiongroups.main.common.challenges.challenge_navigator.model.ChallengeNavigatorModelDelegations.*;

public class ChallengeNavigatorModel implements ChallengeInfoDelegate, ChatDelegate, ResultDelegate, AllModelsDelegate {
    private static ChallengeNavigatorModel model = new ChallengeNavigatorModel();

    private Challenge challenge;
    private List<ChatItem> chatItems;
    private List<User> users;
    private List<String> results;

    public static ChallengeNavigatorModel getInstance() {
        if(model == null){
            model = new ChallengeNavigatorModel();
        }
        return model;
    }

    private ChallengeNavigatorModel() {
    }

    @Override
    public List<String> getResults() {
        return results;
    }

    @Override
    public Challenge getChallenge() {
        return challenge;
    }

    @Override
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public List<ChatItem> getChatItems() {
        return chatItems;
    }

    @Override
    public void setChatItems(List<ChatItem> chatItems) {
        this.chatItems = chatItems;
    }


}


