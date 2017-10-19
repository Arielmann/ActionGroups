package ariel.actiongroups.main.leader.groups;

import android.graphics.Bitmap;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.users.models.Leader;
import ariel.actiongroups.main.common.users.models.User;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class ActionGroup {

    private String objectId;
    private String name;
    private String description;
    private String creationDate;
    private String imageLocalPath;
    private List<Leader> leaders;
    private List<User> users;
    private Map<String, Course> courses;
    private String imageUrl;
    private Bitmap image = ImageUtils.defaultProfileImage;
    private boolean isSilenced = false;

    //Convenience Constructor
    public ActionGroup() {
        this.name = "Action Group";
        this.description = "This is a great group";
        this.courses = new HashMap<>();
        this.users = new ArrayList<>();
        while(users.size() < 4){
            users.add(new User());
        }
        this.leaders = new ArrayList<>();
        leaders.add(new Leader());
    }

    //Called when first time created
    public ActionGroup(String name, String description) { //Convenience Constructor
        this.objectId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.imageLocalPath = "Entity's Local Image Path";
        this.imageUrl = "Entity's Local Image Url";
        this.creationDate = String.valueOf(LocalDateTime.now().toLocalDate());
    }

    //Called when loading from local OR remote database (with creation date)
    public ActionGroup(String objectId, String name, String description, String creationDate) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Entity Info:: Id: " + objectId +
                " Name: " + name +
                " Description: " + description +
                " Creation Date: " + creationDate +
                " Profile image local file path:" + imageLocalPath +
                " Profile image url:" + imageUrl;
    }

    //**Getters**//
    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getImageLocalPath() {
        return imageLocalPath;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Leader> getLeaders() {
        return leaders;
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    //**Setters**//
    public void setImage(Bitmap entityImageBitmap) {
        this.image = entityImageBitmap;
    }

    public void setImageLocalPath(String entityImageLocalPath) {
        this.imageLocalPath = entityImageLocalPath;
    }

    public void setImageUrl(String entityImageUrl) {
        this.imageUrl = entityImageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSilenced(boolean silenced) {
        isSilenced = silenced;
    }

    public boolean isSilenced() {
        return isSilenced;
    }
}




