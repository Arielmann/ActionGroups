package ariel.actiongroups.main.common.groups.groups_list.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.groups_list.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupRow;
import ariel.actiongroups.main.common.groups.groups_list.model.GroupListModel;
import ariel.actiongroups.main.common.groups.groups_list.presenter.GroupListPresenterImpl;
import ariel.actiongroups.main.common.groups.groups_list.presenter.GroupListPresenter;

public class GroupsListFrag extends Fragment implements GroupListViewInterface {

    private TextView noGroupsMessage;
    private String TAG = "Group presenter frag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        GroupListModel contactedUsersModel = GroupListModel.getInstance(getContext());
        initNoMessagesTextViewState(contactedUsersModel.getDataSet());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recyclerViewLayout = inflater.inflate(R.layout.compo_recycler_view, null);
        RecyclerView recyclerView = (RecyclerView) recyclerViewLayout.findViewById(R.id.recyclerView);
        GroupListPresenter presenter = new GroupListPresenterImpl(getContext(), this);
        presenter.configureRecyclerViewWithGroupRowsFromServer((recyclerView));
        noGroupsMessage = (TextView) recyclerViewLayout.findViewById(R.id.noGroupsTextViewInRecyclerView);
        return recyclerViewLayout;
    }

    @Subscribe
    public void onContactedUsersLoadedEvent(OnGroupRowsLoadedEvent event) {
        initNoMessagesTextViewState(event.groupRows);
    }

    private void initNoMessagesTextViewState(List<GroupRow> groupRows) {
        if (groupRows.size() == 0) {
            noGroupsMessage.setVisibility(View.VISIBLE);
        } else {
            noGroupsMessage.setVisibility(View.GONE);
        }
    }
}

