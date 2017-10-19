package ariel.actiongroups.main.common.utils.datamanager;

import com.backendless.BackendlessUser;

import java.util.List;

import ariel.actiongroups.main.common.courses.Course;

public class DataManager {

    private BackendlessUser user;
    private List<Course> courses;

    private static final DataManager manager = new DataManager();

    public static DataManager getInstance() {
        return manager;
    }

    private DataManager() {
    }

    public BackendlessUser getUser() {
        return user;
    }

    public void setUser(BackendlessUser user) {
        this.user = user;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
