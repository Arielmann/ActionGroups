package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import java.util.List;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.abstractutils.GenericRecyclerViewInterface;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;

public class CourseManagerPresenterImpl implements CourseManagerPresenter {

    private GenericRecyclerViewInterface recyclerView;

    public CourseManagerPresenterImpl(GenericRecyclerViewInterface recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void removeCard(Challenge challenge) {
        recyclerView.refreshAdapter();
    }

    @Override
    public void addCard(Challenge challenge) {
        List<Challenge> dataSet = CourseManagerModel.getInstance().getChallenges();
        dataSet.add(challenge);
        recyclerView.refreshAdapter();
    }
}
