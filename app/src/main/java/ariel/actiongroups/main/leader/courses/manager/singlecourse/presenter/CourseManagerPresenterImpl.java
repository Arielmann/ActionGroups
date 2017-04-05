package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;

public class CourseManagerPresenterImpl implements CourseManagerPresenter {

    private GenericRecyclerViewInterface iRecyclerView;

    public CourseManagerPresenterImpl(GenericRecyclerViewInterface iRecyclerView) {
        this.iRecyclerView = iRecyclerView;
    }

    @Override
    public void removeCard(Challenge challenge) {
        iRecyclerView.refreshAdapter();
    }

    @Override
    public void addCard(Challenge challenge) {
        List<Challenge> dataSet = CourseManagerModel.getInstance().getChallenges();
        dataSet.add(challenge);
        iRecyclerView.refreshAdapter();
    }

    @Override
    public void initDummyChallenges(List<Challenge> challenges) {
        for (int i = 0; i < 41; i++) {
            Challenge challenge = new Challenge();
            challenge.setPositionInCourse(i);
            challenge.setName("Challenge " + i);
            challenge.setDescription("Challenge " + i);
            challenges.add(challenge);
        }
    }

    @Override
    public void setChallenges(List<Challenge> challenges) {
        CourseManagerModel.getInstance().setChallenges(challenges);
    }
}
