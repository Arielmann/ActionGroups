package ariel.actiongroups.main.leader.courses.creator.singlecourse.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;

class ChallengeCardVH extends GenericViewHolder implements View.OnClickListener{

    private final TextView challengeNumberTV;
    private final TextView challengeDescriptionTV;
    private List<User> dataSet;
    private Context context;

    ChallengeCardVH(Context context, View itemView, List<User> dataSet) {
        super(itemView);
        this.context = context;
        this.dataSet = dataSet;
        this.challengeNumberTV = (TextView) itemView.findViewById(R.id.challengeCardNumber);
        this.challengeDescriptionTV = (TextView) itemView.findViewById(R.id.challengeCardDescription);
    }

    @Override
    public void setUIDataOnView(int position) {
            final String challengeName = dataSet.get(position).getName();

            if (challengeName != null) {
                this.challengeNumberTV.setText(String.valueOf(position));
                this.challengeDescriptionTV.setText(challengeName);
                //this.groupImageView.setImageResource(R.drawable.running_lions);
            }
        }

    @Override
    public void onClick(View view) {
        EventBus.getDefault().postSticky(dataSet.get(getTag()));
        ActivityStarter.startActivity(context, ChallengeEditorActivity.class);
    }
}