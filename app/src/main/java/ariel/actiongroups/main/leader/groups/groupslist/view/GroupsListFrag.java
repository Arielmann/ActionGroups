package ariel.actiongroups.main.leader.groups.groupslist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.leader.groups.groupslist.adapter.GroupListAdapter;
import ariel.actiongroups.main.leader.groups.groupslist.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.leader.groups.groupslist.model.GroupListModel;
import ariel.actiongroups.main.leader.groups.groupslist.presenter.GroupListPresenter;
import ariel.actiongroups.main.leader.groups.groupslist.presenter.GroupListPresenterImpl;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

public class GroupsListFrag extends Fragment implements GenericRecyclerViewInterface{

    private TextView noGroupsMessage;
    GroupListAdapter adapter;
    private String TAG = GroupsListFrag.class.getSimpleName();

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GroupListModel.getInstance().initDataSet();
        List dataSet = GroupListModel.getInstance().getDataSet();
        adapter = new GroupListAdapter(getContext(), dataSet, (OnActionGroupClicked) getActivity());
        View recyclerViewLayout = inflater.inflate(R.layout.compo_recycler_view, null); //// TODO: 1/19/2017 : Remove null
        RecyclerView recyclerView = (RecyclerView) recyclerViewLayout.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GroupListPresenter presenter = new GroupListPresenterImpl(adapter);
        presenter.configureRecyclerViewWithGroupRowsFromServer();
        noGroupsMessage = (TextView) recyclerViewLayout.findViewById(R.id.emptyDataSetTV);
        return recyclerViewLayout;
    }

    @Subscribe
    public void onGroupsLoadedEvent(OnGroupRowsLoadedEvent event) {
        if (event.groupRows.size() == 0) {
            noGroupsMessage.setVisibility(View.GONE);
            return;
        }
        noGroupsMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}

