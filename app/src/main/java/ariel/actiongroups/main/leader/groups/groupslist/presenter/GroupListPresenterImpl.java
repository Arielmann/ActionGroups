package ariel.actiongroups.main.leader.groups.groupslist.presenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.leader.groups.groupslist.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.leader.groups.groupslist.model.GroupListModel;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

public class GroupListPresenterImpl implements GroupListPresenter {

    private GroupListModel model;
    private GenericRecyclerViewInterface iRecyclerView;

    public GroupListPresenterImpl(GenericRecyclerViewInterface iRecyclerView) {
        this.model = GroupListModel.getInstance();
        this.iRecyclerView = iRecyclerView;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void configureRecyclerViewWithGroupRowsFromServer() {
        final List<ActionGroup>[] dataSet = new List[]{new ArrayList<>()};
       /* Backendless.Persistence.of(AppStrings.UPPER_CASE_GROUPS).find(new AsyncCallback<BackendlessCollection<Map>>() {
            @Override
            public void handleResponse(BackendlessCollection<Map> loadedGroups) {
                dataSet[0] = createDataSetWithDataFromServer(loadedGroups.getData());
                model.setDataSet(dataSet[0]);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
            }
        });*/
    }

    private List<ActionGroup> createDataSetWithDataFromServer(List<Map> rowsFromServer) {
        List<ActionGroup> groupRows = new ArrayList<>();
        //groupRows.add(new GroupRow(UUID.randomUUID().toString(), (String) rowsFromServer.get(0).get(AppStrings.UPPER_CASE_NAME), "no image", "20.11.16", (String) rowsFromServer.get(0).get(AppStrings.DESCRIPTION)));
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        groupRows.add(new ActionGroup());
        model.setDataSet(groupRows);
        iRecyclerView.refreshAdapter();
        EventBus.getDefault().post(new OnGroupRowsLoadedEvent(groupRows));
        return groupRows;
    }
}
