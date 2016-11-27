package ariel.actiongroups.main.client.groups.groups_presenter.model;

import android.graphics.Bitmap;

/**
 * Created by home on 7/2/2016.
 */
public class GroupRow {

    private String name;
    private String image;
    private String lastMessageDate;
    private String lastMessageAsText; //This may be text message or sent image path
    private Bitmap imageBitmap = null;
    private String profileImagePath;

    public GroupRow(String name, String image, String lastMessageDate, String lastTextMessage) {
        this.name = name;
        this.image = image;
        this.lastMessageDate = lastMessageDate;
        this.lastMessageAsText = lastTextMessage;
    }

    public String getImage() {
        return image;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public String getName() {
        return name;
    }

    public String getLastMessageAsText() {
        return lastMessageAsText;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Image is null: " + (imageBitmap == null) +
                " Last message: " + lastMessageAsText + " last message date" + getLastMessageDate();
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }
}




