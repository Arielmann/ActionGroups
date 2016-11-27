package ariel.actiongroups.main.common.challenge_navigator.results;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ariel.actiongroups.R;

/**
 * Created by home on 11/8/2016.
 */
public class CompletionTableViewHolder extends RecyclerView.ViewHolder {
    private final View view;
    protected TextView userNameTv;
    CompletionTableAdapter adpater = new CompletionTableAdapter(null){
    };

    public CompletionTableViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        this.userNameTv = (TextView) view.findViewById(R.id.completedUserTextView);
    }
}
