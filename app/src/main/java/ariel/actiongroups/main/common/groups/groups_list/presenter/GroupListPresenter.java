package ariel.actiongroups.main.common.groups.groups_list.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ariel.actiongroups.main.common.groups.model.ActionGroup;

public interface GroupListPresenter {
    void onDestroy();
    void configureRecyclerViewWithGroupRowsFromServer(RecyclerView recyclerView);

}
