package ariel.actiongroups.main.common.utils.backendutils.searchutils.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.search.presenter.CourseSearchViewPresenterImpl;
import dagger.Component;

@Singleton
@Component(modules={SearchModule.class})
public interface SearchComponent {
    void inject(CourseSearchViewPresenterImpl courseSearchViewPresenter);
}


