package ariel.actiongroups.main.common.groups.groupslist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.groupslist.adapter.GroupListAdapter;
import ariel.actiongroups.main.common.groups.groupslist.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.common.groups.groupslist.model.GroupListModel;
import ariel.actiongroups.main.common.groups.groupslist.presenter.GroupListPresenter;
import ariel.actiongroups.main.common.groups.groupslist.presenter.GroupListPresenterImpl;
import ariel.actiongroups.main.common.utils.abstractutils.GenericRecyclerViewInterface;

public abstract class GenericGroupListActivity extends AppCompatActivity implements GenericRecyclerViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compo_recycler_view);
        GroupListModel.getInstance().initDataSet();
        List dataSet = GroupListModel.getInstance().getDataSet();
        adapter = new GroupListAdapter(this, dataSet, (GroupListViewInterface) this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GroupListPresenter presenter = new GroupListPresenterImpl(adapter);
        presenter.configureRecyclerViewWithGroupRowsFromServer();
        noGroupsMessage = (TextView) findViewById(R.id.noGroupsTextViewInRecyclerView);
    }

    private TextView noGroupsMessage;
    GroupListAdapter adapter;
    private String TAG = GroupsListFrag.class.getName();

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


