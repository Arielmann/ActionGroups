package ariel.actiongroups.main.leader.course.presenter;

import ariel.actiongroups.main.common.challenges.Challenge;

public interface CourseOverviewPresenter {

    void removeCard(Challenge challenge);
    void addCard(Challenge challenge);

    interface CourseOverviewView{

        void refresh();

    }
}
