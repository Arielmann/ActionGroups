package ariel.actiongroups.main.common.groups.groups_list.presenter;

import android.support.v7.widget.RecyclerView;

public interface GroupListPresenter {
    void onDestroy();
    void configureRecyclerViewWithGroupRowsFromServer(RecyclerView recyclerView);

}
