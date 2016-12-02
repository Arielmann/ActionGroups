package ariel.actiongroups.main.common.groups.groups_list.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;
import ariel.actiongroups.main.common.utils.GenericViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

/**
 * Created by home on 7/2/2016.
 */
public class GroupViewHolder extends GenericViewHolder {

    /*
    * This ViewHolder creates ContactedUserRows shown on the
    * ContactedUsersScreen. unlike ChatItems, all
    * ContactedUserRows MUST have images if image is not provided
    * by the contact, there will be a default Image.
    */

    private final View view;
    private final CircleImageView groupdImageView;
    private final TextView nameTextView;
    private final TextView lastMessageTextView;
    private final TextView lastMessageDateTextView;
    private GroupRow[] dataSet;
    private int targetImageHeight;
    private int targetImageWidth;
    private Context context;

    protected GroupViewHolder(Context context, View itemView, GroupRow[] dataSet) {
        super(itemView);
        this.context = context;
        this.view = itemView;
        this.groupdImageView = (CircleImageView) view.findViewById(R.id.conversationImage);
        this.nameTextView = (TextView) view.findViewById(R.id.addressedUser);
        this.lastMessageTextView = (TextView) view.findViewById(R.id.lastTextMessage);
        this.lastMessageDateTextView = (TextView) view.findViewById(R.id.lastMessageDate);
        this.dataSet = dataSet;
        //int[] imageSizes = ImageUtils.chooseImageSizes(context, 13, 13);
        //this.targetImageHeight = imageSizes[0];
        //this.targetImageWidth = imageSizes[1];

    }

    public void setUIDataOnView(int position) {
        try {
            final String imagePath = dataSet[position].getImage();
            final String message =  dataSet[position].getLastMessageAsText();
            final String name =  dataSet[position].getName();
            String lastMessageDate =  dataSet[position].getLastMessageDate();

            if (imagePath != null && message != null && name != null && lastMessageDate != null) {

                this.nameTextView.setText(name);
                this.lastMessageTextView.setText(message);
                lastMessageDate = lastMessageDate.replace("_", ""); //remove the "_" char to prevent parse error
                long lastMessageDateAsLong = Long.parseLong(lastMessageDate);
                Timestamp stampOfLastMessage = new Timestamp(lastMessageDateAsLong);
                Date date = new Date(stampOfLastMessage.getTime());
                this.lastMessageDateTextView.setText(date.toString());

                if ( dataSet[position].getImageBitmap() != null) {
                    //this.groupdImageView.setImageBitmap(dataSet.get(position).getImageBitmap());
                    Log.d("Contacted users VH",  dataSet[position].getName() +
                            " profile image set from inside user data. Path: " +  dataSet[position].getImage());
                    return;
                }

                Storage storage = SimpleStorage.getExternalStorage();
                File profileImageFile = storage.getFile("Make Me Beautiful", "Contact Image: " + name);
                if (profileImageFile != null) {
                    //ImageUtils.createBitmapFromImageSource("" + position, context, this, Uri.fromFile(profileImageFile), targetImageHeight, targetImageWidth); //create the image from the filepath.
                    Log.d("Contacted users VH",  dataSet[position].getName() +
                            " profile image created from file. Path: " +  dataSet[position].getImage());
                }


            }
        } catch (Exception e) {
            new Error("Custom Error: " + e.getMessage());
        }
    }
/*
    @Override
    public void onImageLoaded(String senderName, Bitmap scaledBitmap, ChatItem.ItemType itemType, Uri imageUri) {
        this.groupdImageView.setImageBitmap(scaledBitmap);
        dataSet.get(Integer.parseInt(senderName)).setBitmap(scaledBitmap);
        Log.d("Contacted users VH", "image was loaded from interface and attached to " +  dataSet.get(Integer.parseInt(senderName)).getName());
    }


    @Override
    public void onImageLoadingError() {
        Glide.with(context).load(R.drawable.female_icon).override(targetImageHeight, targetImageHeight).into(groupdImageView);
        groupdImageView.setBorderColor(Color.WHITE);
        groupdImageView.setBorderWidth(2);
        Log.d("Loading Error", "image should be loaded from setDataOnUIView");
    }*/
}

