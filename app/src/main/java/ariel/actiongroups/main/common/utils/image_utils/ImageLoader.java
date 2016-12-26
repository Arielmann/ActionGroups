package ariel.actiongroups.main.common.utils.image_utils;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.concurrent.ExecutionException;

import ariel.actiongroups.main.common.challenges.challenge_navigator.chat.ChatItem;

/**
 * Created by home on 6/25/2016.
 */
public interface ImageLoader {
    void onImageLoaded(String senderName, Bitmap scaledBitmap, ChatItem.ItemType itemType, Uri imageUri) throws ExecutionException, InterruptedException;
}
