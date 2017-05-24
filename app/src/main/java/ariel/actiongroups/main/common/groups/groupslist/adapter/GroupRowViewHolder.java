package ariel.actiongroups.main.common.groups.groupslist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.view.OnActionGroupClicked;
import ariel.actiongroups.main.common.utils.listutils.vh.EntityViewHolder;

public class GroupRowViewHolder extends EntityViewHolder implements View.OnClickListener {

    /*
    * This ViewHolder creates GroupRows shown on the
    * GroupListActivity. unlike ChatItems, all
    * GroupRows MUST have images. if image is not provided
    * by the ActionGroup creator, there will be a default Image.
    */

    private static final String TAG = GroupRowViewHolder.class.getSimpleName();

    private final OnActionGroupClicked onGroupClicked;
    private final List<ActionGroup> dataSet;

    public GroupRowViewHolder(Context context, View itemView, List dataSet, OnActionGroupClicked onGroupClicked) {
        super(context, itemView);
        this.dataSet = dataSet;
        this.onGroupClicked = onGroupClicked;
    }

    public void setUIDataOnView(int position) {
        final String imagePath = dataSet.get(position).getImageLocalPath();
        final String description = dataSet.get(position).getDescription();
        final String name = dataSet.get(position).getName();

        if (imagePath != null && description != null && name != null) {

            setDataOnEntityViews(name, description, dataSet.get(position).getImage());
            this.entityImageView.setImageResource(R.drawable.running_lions);
            //long lastMessageDateAsLong = Long.parseLong(lastMessageDate);
            // Timestamp stampOfLastMessage = new Timestamp(lastMessageDateAsLong);
            // Date date = new Date(stampOfLastMessage.getTime());
            //  this.lastMessageDateTextView.setText(date.toString());

            if (dataSet.get(position).getImage() != null) {
                //this.groupImageView.setImageBitmap(dataSet.get(position).getImageBitmap());
                Log.d(TAG, dataSet.get(position).getName() +
                        " profile image set from inside user data. Path: " + dataSet.get(position).getImage());
            }
        }
    }

    @Override
    public void onClick(View view) {
        int position = this.getLayoutPosition();
        onGroupClicked.onActionGroupClicked(dataSet.get(position - 1));
    }
}

