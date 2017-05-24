package ariel.actiongroups.main.common.utils.backendutils.searchutils.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.presenter.CourseManagerPresenterImpl;
import dagger.Component;

@Singleton
@Component(modules={SearchModule.class})
public interface SearchComponent {
    void inject(CourseSearchViewPresenterImpl courseSearchViewPresenter);
    void inject(CourseManagerPresenterImpl courseManagerPresenter);
}


