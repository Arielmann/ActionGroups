package ariel.actiongroups.main.common;

import android.graphics.Bitmap;

import org.joda.time.LocalDateTime;

import java.util.UUID;

import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public abstract class ActionGroupsEntity {

    private String objectId;
    private String name;
    private String description;
    private String creationDate;
    private String imageLocalPath;

    private String imageUrl;
    private Bitmap image = ImageUtils.defaultProfileImage;
    private boolean isSilenced = false;

    //Called when first time created
    public ActionGroupsEntity(String name, String description) { //Convenience Constructor
        this.objectId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.imageLocalPath = "Entity's Local Image Path";
        this.imageUrl = "Entity's Local Image Url";
        this.creationDate = String.valueOf(LocalDateTime.now().toLocalDate());
    }

    //Called when loading from local OR remote database (with creation date)
    public ActionGroupsEntity(String objectId, String name, String description, String creationDate) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    public ActionGroupsEntity() {

    }

    void saveToDataBases() {
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
