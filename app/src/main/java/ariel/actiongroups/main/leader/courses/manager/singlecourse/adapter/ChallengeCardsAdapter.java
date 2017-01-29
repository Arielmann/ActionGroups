package ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.abstractutils.GenericViewHolder;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;

public class ChallengeCardsAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private List<Challenge> dataSet;
    private Context context;

    public ChallengeCardsAdapter(Context context) {
        this.context = context;
        this.dataSet = CourseManagerModel.getInstance().getChallenges();
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_challenge_card, parent, false);
        return new ChallengeCardViewHolder(context, view, dataSet);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public void remove(Challenge challenge) {
        dataSet.remove(challenge);
    }

}