package ariel.actiongroups.main.common.utils.imageutils;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.concurrent.ExecutionException;

import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.chat.ChatItem;
import ariel.actiongroups.main.common.profiles.models.Leader;

interface ImageLoader {
    void onImageLoaded(String senderName, Bitmap scaledBitmap, ChatItem.ItemType itemType, Uri imageUri) throws ExecutionException, InterruptedException;
}
