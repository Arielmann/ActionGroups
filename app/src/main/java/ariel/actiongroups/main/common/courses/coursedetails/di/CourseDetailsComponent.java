package ariel.actiongroups.main.common.courses.coursedetails.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import dagger.Component;

@Singleton
@Component(modules = {CourseDetailsModule.class})

public interface CourseDetailsComponent {
    CourseDetailsModel injectModel();
}