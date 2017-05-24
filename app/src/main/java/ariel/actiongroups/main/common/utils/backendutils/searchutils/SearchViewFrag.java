package ariel.actiongroups.main.common.utils.backendutils.searchutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import ariel.actiongroups.R;

public class SearchViewFrag extends Fragment {

    private SearchView searchView;
    private OnSearchViewClicked onSearchViewClicked;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View searchViewLayout = inflater.inflate(R.layout.frag_search_view, null);
        this.onSearchViewClicked = (OnSearchViewClicked) getActivity(); //Activity MUST implement search interface
        searchView = (SearchView) searchViewLayout.findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setOnClickListener(onSearchViewClickListener);
        searchView.setOnQueryTextListener(onSearchQuerySubmitted);
        searchView.setOnSearchClickListener(onSearchViewClickListener);
        return searchViewLayout;
    }

    View.OnClickListener onSearchViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onSearchViewClicked.onSearchViewClicked(String.valueOf(searchView.getQuery()));
        }
    };

    SearchView.OnQueryTextListener onSearchQuerySubmitted = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            onSearchViewClicked.onSearchViewClicked(String.valueOf(query));
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
}
