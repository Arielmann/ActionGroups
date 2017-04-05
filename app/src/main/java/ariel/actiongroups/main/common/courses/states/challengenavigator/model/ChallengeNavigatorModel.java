package ariel.actiongroups.main.common.courses.states.challengenavigator.model;

import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.chat.ChatItem;

import static ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModelDelegations.AllModelsDelegate;
import static ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModelDelegations.ChallengeInfoDelegate;
import static ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModelDelegations.ChatDelegate;
import static ariel.actiongroups.main.common.courses.states.challengenavigator.model.ChallengeNavigatorModelDelegations.ResultDelegate;

public class ChallengeNavigatorModel implements ChallengeInfoDelegate, ChatDelegate, ResultDelegate, AllModelsDelegate {
    private static ChallengeNavigatorModel model = new ChallengeNavigatorModel();

    private Challenge challenge;
    private List<ChatItem> chatItems;
    private List<String> results;
    private Course course;

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
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Course getCourse() {
        return course;
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


