package ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.abstractutils.GenericViewHolder;
import ariel.actiongroups.main.leader.challenges.creator.view.CreateChallengeActivity;

class ChallengeCardViewHolder extends GenericViewHolder implements View.OnClickListener {

    private final TextView challengeNumberTV;
    private final TextView challengeDescriptionTV;
    private List<Challenge> dataSet;
    private int targetImageHeight;
    private int targetImageWidth;
    private Context context;


    ChallengeCardViewHolder(Context context, View itemView, List<Challenge> dataSet) {
        super(itemView);
        this.dataSet = dataSet;
        this.challengeNumberTV = (TextView) itemView.findViewById(R.id.challengeCardNumber);
        this.challengeDescriptionTV = (TextView) itemView.findViewById(R.id.challengecardDescription);
    }

    @Override
    public void setUIDataOnView(int position) {
            final String description = dataSet.get(position).getDescription();
            final String name = dataSet.get(position).getName();

            if (name != null && description != null) {
                this.challengeNumberTV.setText(name);
                this.challengeDescriptionTV.setText(description);
                //this.groupImageView.setImageResource(R.drawable.running_lions);
            }
        }

    @Override
    public void onClick(View view) {
        ActivityStarter.startActivity(context, CreateChallengeActivity.class);
    }
}

               /* if (dataSet.get(position).getImageBitmap() != null) {
                    //this.groupImageView.setImageBitmap(dataSet.get(position).getImageBitmap());
                    Log.d("Contacted users VH", dataSet.get(position).getName() +
                            " profile image set from inside user data. Path: " + dataSet.get(position).getImage());
                    return;
                }

                Storage storage = SimpleStorage.getExternalStorage();
                File profileImageFile = storage.getFile("Make Me Beautiful", "Contact Image: " + name);
                if (profileImageFile != null) {
                    //ImageUtils.createBitmapFromImageSource("" + position, context, this, Uri.fromFile(profileImageFile), targetImageHeight, targetImageWidth); //create the image from the filepath.
                    Log.d("Contacted users VH", dataSet.get(position).getName() +
                            " profile image created from file. Path: " + dataSet.get(position).getImage());
                }
            }*/
