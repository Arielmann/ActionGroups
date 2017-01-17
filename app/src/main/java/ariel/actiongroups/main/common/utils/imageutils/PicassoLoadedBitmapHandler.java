package ariel.actiongroups.main.common.utils.imageutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.chat.ChatItem;
import ariel.actiongroups.main.common.groups.ActionGroup;

abstract class PicassoLoadedBitmapHandler {

    /*
    * This abstract class is inherited by chat and profile
    * image picasso targets. it saves code copying and
    * allows its children to retry loading the image upon error
    * */

    private ImageLoader loader;
    private ActionGroup group;
    private Context context;
    private String url;
    private String senderName;

    //Load profile image
    PicassoLoadedBitmapHandler(Context context, ImageLoader interfaceHolder, ActionGroup group, String url) {
        this.context = context;
        this.group = group;
        this.loader = interfaceHolder;
        this.url = url;
    }

    //Load image for chat item
    PicassoLoadedBitmapHandler(Context context, ImageLoader interfaceHolder, String senderName, String url) {
        this.context = context;
        this.senderName = senderName;
        this.loader = interfaceHolder;
        this.url = url;
    }

    /*
    * There are 2 scenarios to handle a downloaded bitmap:
    *
    * 1. set it as the group's profile
    * image (targeted group is transferred as reference, no
    * interface required)
    *
    * 2. activate interface implemented in the
    * ChatScreen for further treatment (no group object required)
    * */

    void handleBitmap(Bitmap bitmap) {
        String TAG = PicassoChatImageTarget.class.getName();
        Log.d(TAG, "Bitmap loaded in Picasso bitmap handler");
        int[] imageSizes = ImageUtils.chooseImageSizes(context, 2, 2);
        //TODO: remove fixed sizes when done debugging
        Bitmap finalBitmap = Bitmap.createScaledBitmap(bitmap, 100, 200, true);
        Log.d(TAG, "final image created");
        ImageLoader loader = this.loader;
        try {
            loader.onImageLoaded(senderName, finalBitmap, ChatItem.ItemType.IMAGE_LEFT, null);
            Log.d(TAG, "onImageLoaded interface activated");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Log.d(TAG, "Interface is null, image is downloaded from ReadingStylists AsyncTask");
        }
        try {
            group.setGroupImageBitmap(finalBitmap);
            Log.d(TAG, group.getName() + "'s downloaded image is set as her bitmap property");
        } catch (NullPointerException e) {
            Log.e(TAG, "group is null, chat item is handled. no need to set profile image");
        }
    }

    ImageLoader getLoader() {
        return loader;
    }

    public ActionGroup getGroup() {
        return group;
    }

    public Context getContext() {
        return context;
    }

    String getUrl() {
        return url;
    }

    String getSenderName() {
        return senderName;
    }
}
