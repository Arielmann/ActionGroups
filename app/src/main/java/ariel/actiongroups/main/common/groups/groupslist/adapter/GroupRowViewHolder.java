package ariel.actiongroups.main.common.groups.groupslist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.view.OnActionGroupClicked;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;

public class GroupRowViewHolder extends GenericViewHolder implements View.OnClickListener{

    /*
    * This ViewHolder creates GroupRows shown on the
    * GroupListActivity. unlike ChatItems, all
    * GroupRows MUST have images. if image is not provided
    * by the ActionGroup creator, there will be a default Image.
    */

    private static final String TAG = GroupRowViewHolder.class.getSimpleName();

    private final OnActionGroupClicked onGroupClicked;
    private Context context;
    private final CircleImageView groupImageView;
    private final TextView nameTextView;
    private final TextView lastMessageTextView;
    private final List<ActionGroup> dataSet;
    private int targetImageHeight;
    private int targetImageWidth;

    public GroupRowViewHolder(Context context, View itemView, List dataSet, OnActionGroupClicked onGroupClicked) {
       /* Distinction is made between context and
         groupClickListener interface for better
        */
        super(itemView);
        this.context = context;
        this.groupImageView = (CircleImageView) itemView.findViewById(R.id.groupRowImageView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.groupRowName);
        this.lastMessageTextView = (TextView) itemView.findViewById(R.id.lastTextMessage);
        this.dataSet = dataSet;
        this.onGroupClicked = onGroupClicked;
        //int[] imageSizes = ImageUtils.chooseImageSizes(context, 13, 13);
        //this.targetImageHeight = imageSizes[0];
        //this.targetImageWidth = imageSizes[1];

    }

    public void setUIDataOnView(int position) {
        final String imagePath = dataSet.get(position).getImageLocalPath();
        final String message = dataSet.get(position).getDescription();
        final String name = dataSet.get(position).getName();
        String lastMessageDate = dataSet.get(position).getCreationDate();

        if (imagePath != null && message != null && name != null && lastMessageDate != null) {

            this.nameTextView.setText(name);
            this.lastMessageTextView.setText(message);
            lastMessageDate = lastMessageDate.replace("_", ""); //remove the "_" char to prevent parse error
            //long lastMessageDateAsLong = Long.parseLong(lastMessageDate);
            // Timestamp stampOfLastMessage = new Timestamp(lastMessageDateAsLong);
            // Date date = new Date(stampOfLastMessage.getTime());
            //  this.lastMessageDateTextView.setText(date.toString());
            this.groupImageView.setImageResource(R.drawable.running_lions);

            if (dataSet.get(position).getImage() != null) {
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
        int position = this.getLayoutPosition();
        onGroupClicked.onActionGroupClicked(dataSet.get(position - 1));
       /* Intent singleChallengeScreen = new Intent(context, ChallengeNavigationActivity.class);
        singleChallengeScreen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ActionGroup group = new ActionGroup();
        EventBus.getDefault().postSticky(group); //send data on this group
        context.startActivity(singleChallengeScreen); //TODO: disable click after first time, else it search database twice*/
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

