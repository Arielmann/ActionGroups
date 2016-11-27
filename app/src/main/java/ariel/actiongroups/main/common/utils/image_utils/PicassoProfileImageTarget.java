package ariel.actiongroups.main.common.utils.image_utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import ariel.actiongroups.main.client.groups.groups_presenter.model.ActionGroup;

/**
 * Created by home on 8/24/2016.
 */
public class PicassoProfileImageTarget extends PicassoLoadedBitmapHandler implements Target {

    private int counter;
    private final String TAG = "Picasso profile target";

    public PicassoProfileImageTarget(Context context, ImageLoader interfaceHolder, ActionGroup group, String url) {
        super(context, interfaceHolder, group, url);
    }


    @Override
    public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
        Log.d(TAG, "Bitmap loaded in Picasso profile image target");
        super.handleBitmap(bitmap);
        counter = 0;
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        if (counter > 5) {
            Log.d(TAG, "Loading failed for the" + counter + 1 + " time.");
            ImageUtils.downloadProfileImage(super.getContext(),
                    super.getLoader(),
                    super.getGroup(),
                    super.getUrl());
            counter++;
        }
    }


    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
    }
};

