package ariel.actiongroups.main.common.groups.groups_list.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ariel.actiongroups.main.common.groups.groups_list.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupListModel;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;
import ariel.actiongroups.main.common.groups.groups_list.presenter.adapter.GroupListAdapter;
import ariel.actiongroups.main.common.groups.groups_list.view.GroupListViewInterface;
import ariel.actiongroups.main.common.utils.AppStrings;

public class GroupListPresenterImpl implements GroupListPresenter {

    private GroupListViewInterface view;
    private GroupListModel model;
    private GroupListAdapter adapter;

    public GroupListPresenterImpl(Context context, GroupListViewInterface view) {
        this.view = view;
        this.model = GroupListModel.getInstance(context);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void configureRecyclerViewWithGroupRowsFromServer(final RecyclerView recyclerView) {
        final List<GroupRow>[] dataSet = new List[]{new ArrayList<>()};
        Backendless.Persistence.of(AppStrings.GROUPS).find(new AsyncCallback<BackendlessCollection<Map>>() {
            @Override
            public void handleResponse(BackendlessCollection<Map> loadedGroups) {
                dataSet[0] = createDataSetWithDataFromServer(loadedGroups.getData());
                model.setDataSet(dataSet[0]);
                model.setAdapter(dataSet[0]);
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(model.getLayoutManager());
                recyclerView.setAdapter(model.getAdapter());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
            }
        });
    }

    private List<GroupRow> createDataSetWithDataFromServer(List<Map> rowsFromServer) {
        List<GroupRow> groupRows = new ArrayList<>();
        groupRows.add(new GroupRow(UUID.randomUUID().toString(), (String) rowsFromServer.get(0).get(AppStrings.NAME), "no image", "20.11.16", (String) rowsFromServer.get(0).get(AppStrings.DESCRIPTION)));
        groupRows.add(new GroupRow(UUID.randomUUID().toString(), "October Lions", "no image", "20.11.16", "Do 200 pushups before dinner"));
        groupRows.add(new GroupRow(UUID.randomUUID().toString(), "November Lions", "no image", "20.11.16", "Do 300 pushups before dinner"));
        groupRows.add(new GroupRow(UUID.randomUUID().toString(), "December Lions", "no image", "20.11.16", "Do 400 pushups before dinner"));
        groupRows.add(new GroupRow(UUID.randomUUID().toString(), "January Lions", "no image", "20.11.16", "Do 500 pushups before dinner"));

        EventBus.getDefault().post(new OnGroupRowsLoadedEvent(groupRows));
        return groupRows;

    }
}
