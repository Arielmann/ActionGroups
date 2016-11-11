package ariel.actiongroups.main.main.main.results;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ariel.actiongroups.R;

/**
 * Created by home on 11/8/2016.
 */
public class CompletionTableAdapter extends RecyclerView.Adapter<CompletionTableViewHolder> {

    private List<String> dataSet;

    public CompletionTableAdapter(List<String> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public CompletionTableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.compo_user_completed_mission, parent, false);

        return new CompletionTableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CompletionTableViewHolder holder, int position) {
        holder.userNameTv.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
