package ariel.actiongroups.main.common.profiles.models;

import android.graphics.Bitmap;

import org.joda.time.LocalDateTime;

import java.util.UUID;

import ariel.actiongroups.R;

public abstract class ActionGroupsEntity {

    public enum EntityType{

        GROUP(R.layout.vh_group_row),
        CHALLENGE(R.layout.vh_group_row),
        COURSE(R.layout.vh_group_row),
        USER(R.layout.vh_group_row),
        LEADER(R.layout.vh_group_row);

        private int viewValue;

        EntityType(int viewValue) {
            this.viewValue = viewValue;
        }
    }

    private String id;
    private String name;
    private String description;
    private String creationDate;
    private Bitmap image;
    private String imageLocalPath;
    private String imageUrl;
    private boolean isSilenced = false;

    public ActionGroupsEntity(String name, String description) { //Convenience Constructor
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.imageLocalPath = "Entity's Local Image Path";
        this.imageUrl = "Entity's Local Image Url";
        this.creationDate = String.valueOf(LocalDateTime.now().toLocalDate());
    }

    //Called when first time created
    public ActionGroupsEntity(String name, String description, String imageLocalPath) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.creationDate = String.valueOf(LocalDateTime.now().toLocalDate());
    }

    //Called when loading from local database (with creation date)
    public ActionGroupsEntity(String id, String name, String description, String creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }


    void saveToDataBases() {
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " Name: " + name +
                " Description: " + description +
                " Creation Date: " + creationDate +
                " Profile image local file path:" + imageLocalPath +
                " Profile image url:" + imageUrl;
    }

    //**Getters**//
    public String getId() {
        return id;
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

    public boolean getSilenced() {
        return isSilenced;
    }


}
