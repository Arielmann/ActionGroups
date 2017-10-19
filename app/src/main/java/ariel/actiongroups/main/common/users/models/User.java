package ariel.actiongroups.main.common.users.models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.backendless.BackendlessUser;

import java.util.HashMap;
import java.util.Map;

import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class User extends BackendlessUser {

    private String name;
    private String description;
    private String creationDate;
    private String profileImageUrl;

    private Bitmap image = ImageUtils.defaultProfileImage;
    private boolean isSilenced = false;

    private String location;
    private String gcmToken = "el9hAVOFKos:APA91bFEeFnKCt9Rm-Bv7384Zo0SWCUCG21iG8BGuOztmpaexo9DYSMf9Ln2KTE7EPAx_fiW7bUPce8xS-_vzOHYsHYkyhLH5s7ehtOn2BBH3UFT6bixs6cyA-1_0qdlauEMr7vxz87p";

    public User(String name, String description, String location, String profileImageUrl, String token, String creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.profileImageUrl = profileImageUrl;
        this.location = location;
        this.gcmToken = token;
    }

    //Convenience Constructor
    public User() {
       this.name = "Ariel";
        this.description = "I am a happy user";
        this.location = "Yigal Alon 46, Tel Aviv-Yafo";
    }


    @Override
    public String toString() {
        return getName() +
                " from " + location +
                " Token " + gcmToken +
                " Description: " + getDescription() +
                " Profile Image URL:" + getProfileImageUrl();
    }


    //*******************Getters****************************//
    public String getGcmToken() {
        return gcmToken;
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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public Bitmap getImage() {
        return image;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public java.lang.String getLocation() {
        return location;
    }

    //***************************Setters****************************//

    public void setLocation(java.lang.String location) {
        this.location = location;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setSilenced(boolean silenced) {
        isSilenced = silenced;
    }

    public void setGcmToken(String gcmToken) {
        this.gcmToken = gcmToken;
    }

}
