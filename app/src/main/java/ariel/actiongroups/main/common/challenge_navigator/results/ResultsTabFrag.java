package ariel.actiongroups.main.common.challenge_navigator.results;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.R;

/**
 * Created by home on 11/7/2016.
 */
public class ResultsTabFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CompletionTableModel model = new CompletionTableModel(getContext());
        View layout = inflater.inflate(R.layout.frag_results_tab, container, false);
        TextView tvResultsHeader = (TextView) layout.findViewById(R.id.tvResultsHeader);
        tvResultsHeader.setText("Only 2 people left for completion!");
        RecyclerView completionTableRecyclerView = (RecyclerView) layout.findViewById(R.id.completionTableRecyclerView);
        List<String> users = new ArrayList<>();
        users.add("Ariel");
        users.add("Ben");
        users.add("Rotem");
        completionTableRecyclerView.setAdapter(model.getAdapter());
        completionTableRecyclerView.setLayoutManager(model.getLayoutManager());
        return layout;
    }
}
