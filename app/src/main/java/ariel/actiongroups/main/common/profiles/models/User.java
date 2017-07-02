package ariel.actiongroups.main.common.profiles.models;

import ariel.actiongroups.main.common.ActionGroupsEntity;

public class User extends ActionGroupsEntity {

    private String location;
    private String gcmToken = "el9hAVOFKos:APA91bFEeFnKCt9Rm-Bv7384Zo0SWCUCG21iG8BGuOztmpaexo9DYSMf9Ln2KTE7EPAx_fiW7bUPce8xS-_vzOHYsHYkyhLH5s7ehtOn2BBH3UFT6bixs6cyA-1_0qdlauEMr7vxz87p";


    public User(String id, String name, String description, String location, String profileImageUrl, String token, String creationDate) {
        super(id, name, description, creationDate);
        this.location = location;
        this.gcmToken = token;
    }

    //Convenience Constructor
    public User() {
        super("Ariel Mann", "I am an actiongroups User");
        this.location = "Yigal Alon 46, Tel Aviv-Yafo";
    }


    @Override
    public String toString() {
        return getName() +
                " from " + location +
                " Token " + gcmToken +
                " Description: " + getDescription() +
                " Profile local image file:" + getImageLocalPath();
    }


    //*******************Getters****************************//
    public String getGcmToken() {
        return gcmToken;
    }

    public java.lang.String getLocation() {
        return location;
    }

    //***************************Setters****************************//

    public void setLocation(java.lang.String location) {
        this.location = location;
    }
}
