package ariel.actiongroups.main.leader.courses.creator.singlecourse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karumi.headerrecyclerview.HeaderRecyclerViewAdapter;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.leader.courses.creator.singlecourse.model.CourseDesignerModel;

public class CourseDesignerAdapter extends HeaderRecyclerViewAdapter<GenericViewHolder, String, User, String> {

    private List<User> dataSet;
    private Context context;

    public CourseDesignerAdapter(Context context) {
        this.context = context;
        this.dataSet = CourseDesignerModel.getInstance().getChallenges();
    }

    @Override
    protected GenericViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        final View headerView = getLayoutInflater(parent).inflate(R.layout.header_simple_title, parent, false);
        return new CourseDesignerHeader(headerView, getHeader());
    }

    @Override
    protected void onBindHeaderViewHolder(GenericViewHolder holder, int position) {
        holder.setUIDataOnView(0);
    }

    @Override
    protected GenericViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_challenge_card, parent, false);
        return new ChallengeCardVH(context, itemView, dataSet);
    }

    @Override
    protected void onBindItemViewHolder(GenericViewHolder holder, int position) {
        holder.setTag(position); //enable tracking the specified challenge within ChallengeCardVH class
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
        holder.setUIDataOnView(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void remove(User challenge) {
        dataSet.remove(challenge);
    }

    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }
}