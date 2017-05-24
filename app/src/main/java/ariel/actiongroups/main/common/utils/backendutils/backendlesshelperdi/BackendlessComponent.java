package ariel.actiongroups.main.common.utils.backendutils.backendlesshelperdi;

import javax.inject.Singleton;

import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;
import dagger.Component;

@Singleton
@Component(modules={BackendlessModule.class})
public interface BackendlessComponent {
    void inject(ChallengeManagerPresenterImpl challengeManagerPresenter);
}
