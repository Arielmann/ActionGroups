package ariel.actiongroups.main.common.profiles.models;

import android.graphics.Bitmap;

import org.joda.time.LocalDateTime;

import java.util.UUID;

public abstract class ActionGroupsEntity {

    private String id;
    private String name;
    private String description;
    private String creationDate;
    private Bitmap imageBitmap;
    private String imageLocalPath;
    private String imageUrl;

    public ActionGroupsEntity() { //Convenience Constructor
        this.id = UUID.randomUUID().toString();
        this.name = "Entitiy's name";
        this.description = "Entity's Description";
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

    void saveToDataBases() {
    }

    public void setImageBitmap(Bitmap entityImageBitmap) {
        this.imageBitmap = entityImageBitmap;
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

    @Override
    public String toString() {
        return "Id: " + id +
                " Name: " + name +
                " Description: " + description +
                " Creation Date: " + creationDate +
                " Profile image local file path:" + imageLocalPath +
                " Profile image url:" + imageUrl;
    }
}
