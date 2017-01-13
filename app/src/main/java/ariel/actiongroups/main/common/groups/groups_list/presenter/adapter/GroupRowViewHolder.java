package ariel.actiongroups.main.common.groups.groups_list.presenter.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.challenge_navigator.view.ChallengeNavigationActivity;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;
import ariel.actiongroups.main.common.groups.model.ActionGroup;
import ariel.actiongroups.main.common.utils.abstractions.GenericViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by home on 7/2/2016.
 */
public class GroupRowViewHolder extends GenericViewHolder implements View.OnClickListener {

    /*
    * This ViewHolder creates ContactedUserRows shown on the
    * ContactedUsersScreen. unlike ChatItems, all
    * ContactedUserRows MUST have images if image is not provided
    * by the contact, there will be a default Image.
    */

    private static final String TAG = GroupRowViewHolder.class.getName();
    private final CircleImageView groupImageView;
    private final TextView nameTextView;
    private final TextView lastMessageTextView;
    private List<GroupRow> dataSet;
    private int targetImageHeight;
    private int targetImageWidth;
    private Context context;

    GroupRowViewHolder(Context context, View itemView, List dataSet) {
        super(itemView);
        this.context = context;
        this.groupImageView = (CircleImageView) itemView.findViewById(R.id.groupRowImageView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.groupRowName);
        this.lastMessageTextView = (TextView) itemView.findViewById(R.id.lastTextMessage);
        this.dataSet = dataSet;
        //int[] imageSizes = ImageUtils.chooseImageSizes(context, 13, 13);
        //this.targetImageHeight = imageSizes[0];
        //this.targetImageWidth = imageSizes[1];

    }

    public void setUIDataOnView(int position) {
        final String imagePath = dataSet.get(position).getImage();
        final String message = dataSet.get(position).getLastMessageAsText();
        final String name = dataSet.get(position).getName();
        String lastMessageDate = dataSet.get(position).getLastMessageDate();

        if (imagePath != null && message != null && name != null && lastMessageDate != null) {

            this.nameTextView.setText(name);
            this.lastMessageTextView.setText(message);
            lastMessageDate = lastMessageDate.replace("_", ""); //remove the "_" char to prevent parse error
            //long lastMessageDateAsLong = Long.parseLong(lastMessageDate);
            // Timestamp stampOfLastMessage = new Timestamp(lastMessageDateAsLong);
            // Date date = new Date(stampOfLastMessage.getTime());
            //  this.lastMessageDateTextView.setText(date.toString());
            this.groupImageView.setImageResource(R.drawable.running_lions);

            if (dataSet.get(position).getImageBitmap() != null) {
                //this.groupImageView.setImageBitmap(dataSet.get(position).getImageBitmap());
                Log.d(TAG, dataSet.get(position).getName() +
                        " profile image set from inside user data. Path: " + dataSet.get(position).getImage());
                return;
            }

            Storage storage = SimpleStorage.getExternalStorage();
            File profileImageFile = storage.getFile("Make Me Beautiful", "Contact Image: " + name);
            if (profileImageFile != null) {
                //ImageUtils.createBitmapFromImageSource("" + position, context, this, Uri.fromFile(profileImageFile), targetImageHeight, targetImageWidth); //create the image from the filepath.
                Log.d(TAG, dataSet.get(position).getName() +
                        " profile image created from file. Path: " + dataSet.get(position).getImage());
            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent singleChallengeScreen = new Intent(context, ChallengeNavigationActivity.class);
        singleChallengeScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ActionGroup group = new ActionGroup();
        EventBus.getDefault().postSticky(group); //send data on this group
        context.startActivity(singleChallengeScreen); //TODO: disable click after first time, else it search database twice
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
        Glide.with(context).load(R.drawable.female_icon).override(targetImageHeight, targetImageHeight).into(groupImageView);
        groupImageView.setBorderColor(Color.WHITE);
        groupImageView.setBorderWidth(2);
        Log.d("Loading Error", "image should be loaded from setDataOnUIView");
    }*/
}

