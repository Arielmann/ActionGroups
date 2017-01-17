package ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter;

import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.adapter.presenter.ChallengeCardsAdapterPresenter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.adapter.view.ChallengeAdapterView;

public class CourseManagerPresenterImpl implements CourseManagerPresenter {

    private ChallengeCardsAdapterPresenter adapterPresenter;
    private ChallengeAdapterView adapterView;

    public CourseManagerPresenterImpl(ChallengeCardsAdapterPresenter presenter, ChallengeAdapterView view) {
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

    @Override
    public void onDestroy() {
        adapterView = null;
        adapterPresenter = null;
    }
}
