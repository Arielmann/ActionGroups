package ariel.actiongroups.main.main.main.groups.model;

import android.graphics.Bitmap;

/**
 * Created by home on 7/2/2016.
 */
public class GroupRow {

    private String addressedUserName;
    private String profileImagePath;
    private String lastMessageDate;
    private String lastMessageAsText; //This may be text message or sent image path
    private Bitmap imageBitmap = null;

    public GroupRow(String addressedUserName, String profileImage, String lastMessageDate, String lastTextMessage) {
        this.addressedUserName = addressedUserName;
        this.profileImagePath = profileImage;
        this.lastMessageDate = lastMessageDate;
        this.lastMessageAsText = lastTextMessage;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public String getAddressedUserName() {
        return addressedUserName;
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
        return "Name: " + addressedUserName + " Image is null: " + (imageBitmap == null) +
                " Last message: " + lastMessageAsText + " last message date" + getLastMessageDate();
    }
}




