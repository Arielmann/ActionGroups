package ariel.actiongroups.main.common.utils.backendutils.backebdless.di.helper;

import javax.inject.Singleton;

import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;
import dagger.Component;

@Component(modules={BlHelperModule.class})
@Singleton
public interface BlHelperComponent {
    void inject(ChallengeManagerPresenterImpl challengeManagerPresenter);
}
