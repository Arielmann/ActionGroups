package ariel.actiongroups.main.leader.course.creator.presenter;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.course.creator.presenter.adapter.presenter.ChallengeCardsAdapterPresenter;
import ariel.actiongroups.main.leader.course.creator.presenter.adapter.view.ChallengeAdapterView;

public class CourseOverviewPresenterImpl implements CourseOverviewPresenter {

    private ChallengeCardsAdapterPresenter adapterPresenter;
    private ChallengeAdapterView adapterView;

    public CourseOverviewPresenterImpl(ChallengeCardsAdapterPresenter presenter, ChallengeAdapterView view) {
        this.adapterPresenter = presenter;
        this.adapterView = view;
    }

    @Override
    public void removeCard(Challenge challenge) {

    }

    @Override
    public void addCard(Challenge challenge) {
        adapterPresenter.add(challenge);
        adapterView.refresh();
    }
}
