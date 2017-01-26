package ariel.actiongroups.main.common.groups.groupslist.presenter;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.common.groups.groupslist.model.GroupListModel;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.abstractutils.GenericRecyclerViewInterface;

public class GroupListPresenterImpl implements GroupListPresenter {

    private GroupListModel model;
    private GenericRecyclerViewInterface adapterView;

    public GroupListPresenterImpl(GenericRecyclerViewInterface adapterView) {
        this.model = GroupListModel.getInstance();
        this.adapterView = adapterView;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void configureRecyclerViewWithGroupRowsFromServer() {
        final List<ActionGroup>[] dataSet = new List[]{new ArrayList<>()};
        Backendless.Persistence.of(AppStrings.GROUPS).find(new AsyncCallback<BackendlessCollection<Map>>() {
            @Override
            public void handleResponse(BackendlessCollection<Map> loadedGroups) {
                dataSet[0] = createDataSetWithDataFromServer(loadedGroups.getData());
                model.setDataSet(dataSet[0]);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
            }
        });
    }

    private List<ActionGroup> createDataSetWithDataFromServer(List<Map> rowsFromServer) {
        List<ActionGroup> groupRows = new ArrayList<>();
        //groupRows.add(new GroupRow(UUID.randomUUID().toString(), (String) rowsFromServer.get(0).get(AppStrings.NAME), "no image", "20.11.16", (String) rowsFromServer.get(0).get(AppStrings.DESCRIPTION)));
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        model.setDataSet(groupRows);
        adapterView.refreshAdapter();
        EventBus.getDefault().post(new OnGroupRowsLoadedEvent(groupRows));
        return groupRows;
    }
}
