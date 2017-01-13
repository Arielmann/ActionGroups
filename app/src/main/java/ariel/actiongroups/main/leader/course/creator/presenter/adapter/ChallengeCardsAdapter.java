package ariel.actiongroups.main.leader.course.creator.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.abstractions.GenericViewHolder;
import ariel.actiongroups.main.leader.course.creator.presenter.adapter.view.ChallengeAdapterView;
import ariel.actiongroups.main.leader.course.creator.presenter.adapter.presenter.ChallengeCardsAdapterPresenter;

public class ChallengeCardsAdapter extends RecyclerView.Adapter<GenericViewHolder> implements ChallengeCardsAdapterPresenter, ChallengeAdapterView {

    private List<Challenge> dataSet;
    private Context context;

    public ChallengeCardsAdapter(Context context) {
        this.context = context;
        this.dataSet = new ArrayList<>();
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compo_challenge_card, parent, false);
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

    @Override
    public void add(Challenge challenge) {
        dataSet.add(challenge);

    }

    @Override
    public void remove(Challenge challenge) {
        dataSet.remove(challenge);
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }
}