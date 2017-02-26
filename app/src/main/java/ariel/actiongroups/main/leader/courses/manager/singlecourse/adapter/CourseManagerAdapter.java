package ariel.actiongroups.main.leader.courses.manager.singlecourse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.headerrecyclerview.HeaderRecyclerViewAdapter;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;

public class CourseManagerAdapter extends HeaderRecyclerViewAdapter<GenericViewHolder, String, Challenge, String> {

    private List<Challenge> dataSet;
    private Context context;

    public CourseManagerAdapter(Context context) {
        this.context = context;
        this.dataSet = CourseManagerModel.getInstance().getChallenges();
    }

    @Override
    protected GenericViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        final View headerView = getLayoutInflater(parent).inflate(R.layout.header_simple_title, parent, false);
        return new CourseManagerHeader(headerView, getHeader());
    }

    @Override
    protected void onBindHeaderViewHolder(GenericViewHolder holder, int position) {
        holder.setUIDataOnView(0);
    }

    @Override
    protected GenericViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        final View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_challenge_card, parent, false);
        return new ChallengeCardVH(context, header, dataSet);
    }

    @Override
    protected void onBindItemViewHolder(GenericViewHolder holder, int position) {
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

    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }
}