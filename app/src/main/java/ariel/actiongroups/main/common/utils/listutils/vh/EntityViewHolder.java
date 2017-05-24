package ariel.actiongroups.main.common.utils.listutils.vh;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import ariel.actiongroups.R;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class EntityViewHolder extends GenericViewHolder {

    private static final String TAG = EntityViewHolder.class.getSimpleName();
    protected final CircleImageView entityImageView;
    protected final TextView entityNameTV;
    protected final TextView entityDescriptionMessageTV;

    protected Context context;
    //int[] imageSizes = ImageUtils.chooseImageSizes(context, 13, 13);
    //this.targetProfileImageHeight = imageSizes[0];
    //this.targetImageWidth = imageSizes[1];

    public EntityViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.context = context;
        this.entityImageView = (CircleImageView) itemView.findViewById(R.id.entityCilcleImageView);
        this.entityNameTV = (TextView) itemView.findViewById(R.id.entityRowNameTV);
        this.entityDescriptionMessageTV = (TextView) itemView.findViewById(R.id.entityRowDescriptionTV);
    }

    protected void setDataOnEntityViews(String entityName, String entittyDescription, Bitmap profileImage) {
        this.entityNameTV.setText(entityName);
        this.entityDescriptionMessageTV.setText(entittyDescription);

        if (profileImage != null) {
            entityImageView.setImageBitmap(profileImage);
            Log.d(TAG, entityName + " profile image set from inside user data");
        } else {
            this.entityImageView.setImageResource(R.drawable.running_lions);
        }
    }

    Storage storage = SimpleStorage.getExternalStorage();
    //File profileImageFile = storage.getFile(TAG, "Contact Image: " + name); TODO: fix name

}
    /*
    @Override
    public void onImageLoaded(String senderName, Bitmap scaledBitmap, ChatItem.ItemType itemType, Uri imageUri) {
        this.groupImageView.setImageBitmap(scaledBitmap);
        dataSet.get(Integer.parseInt(senderName)).setBitmap(scaledBitmap);
        Log.d("Contacted users VH", "image was loaded from interface and attached to " +  dataSet.get(Integer.parseInt(senderName)).getName());
    }


    @Override
    public void onImageLoadingError() {
        Glide.with(context).load(R.drawable.female_icon).override(targetProfileImageHeight, targetProfileImageHeight).into(groupImageView);
        groupImageView.setBorderColor(Color.WHITE);
        groupImageView.setBorderWidth(2);
        Log.d("Loading Error", "image should be loaded from setDataOnUIView");
    }*/

