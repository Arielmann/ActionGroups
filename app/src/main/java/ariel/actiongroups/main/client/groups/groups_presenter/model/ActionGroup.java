package ariel.actiongroups.main.client.groups.groups_presenter.model;

import android.graphics.Bitmap;

/**
 * Created by home on 11/18/2016.
 */
public class ActionGroup {
    private String name;
    private Bitmap groupImageBitmap;
    private String profileImagePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserImageBitmap(Bitmap groupImageBitmap) {
        this.groupImageBitmap = groupImageBitmap;
    }

    public Bitmap getGroupImageBitmap() {
        return groupImageBitmap;
    }

    public void setGroupImageBitmap(Bitmap groupImageBitmap) {
        this.groupImageBitmap = groupImageBitmap;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }
}
