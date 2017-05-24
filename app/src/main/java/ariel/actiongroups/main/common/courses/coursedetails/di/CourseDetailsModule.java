package ariel.actiongroups.main.common.courses.coursedetails.di;

import javax.inject.Singleton;

import ariel.actiongroups.main.common.courses.coursedetails.model.CourseDetailsModel;
import dagger.Module;
import dagger.Provides;

@Module
public class CourseDetailsModule {

    @Provides
    @Singleton
    CourseDetailsModel provideCourseDetailsModel(){
        return CourseDetailsModel.getInstance();
    }
}
