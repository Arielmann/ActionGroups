package ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeManagerActivity;

class ChallengeCardVH extends GenericViewHolder implements View.OnClickListener {

    private final TextView challengeNumberTV;
    private final TextView challengeDescriptionTV;
    private List<Challenge> dataSet;
    private Context context;

    ChallengeCardVH(Context context, View itemView, List<Challenge> dataSet) {
        super(itemView);
        this.context = context;
        this.dataSet = dataSet;
        this.challengeNumberTV = (TextView) itemView.findViewById(R.id.challengeCardNumber);
        this.challengeDescriptionTV = (TextView) itemView.findViewById(R.id.challengeCardDescription);
    }

    @Override
    public void setUIDataOnView(int position) {
            final String description = dataSet.get(position).getDescription();
            final String name = dataSet.get(position).getName();

            if (name != null && description != null) {
                this.challengeNumberTV.setText(String.valueOf(position));
                this.challengeDescriptionTV.setText(description);
                //this.groupImageView.setImageResource(R.drawable.running_lions);
            }
        }

    @Override
    public void onClick(View view) {
        ActivityStarter.startActivity(context, ChallengeManagerActivity.class);
    }
}