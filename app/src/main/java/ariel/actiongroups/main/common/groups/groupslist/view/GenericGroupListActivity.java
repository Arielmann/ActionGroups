package ariel.actiongroups.main.common.groups.groupslist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.CompoRecyclerViewBinding;
import ariel.actiongroups.main.common.groups.groupslist.adapter.GroupListAdapter;
import ariel.actiongroups.main.common.groups.groupslist.events.OnGroupRowsLoadedEvent;
import ariel.actiongroups.main.common.groups.groupslist.model.GroupListModel;
import ariel.actiongroups.main.common.groups.groupslist.presenter.GroupListPresenter;
import ariel.actiongroups.main.common.groups.groupslist.presenter.GroupListPresenterImpl;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericRecyclerViewInterface;

public abstract class GenericGroupListActivity extends AppCompatActivity implements GenericRecyclerViewInterface {
    CompoRecyclerViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.compo_recycler_view);
        GroupListModel.getInstance().initDataSet();
        List dataSet = GroupListModel.getInstance().getDataSet();
        adapter = new GroupListAdapter(this, dataSet, (OnActionGroupClicked) this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        GroupListPresenter presenter = new GroupListPresenterImpl(adapter);
        presenter.configureRecyclerViewWithGroupRowsFromServer();
    }

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
            binding.emptyDataSetTV.setVisibility(View.GONE);
            return;
        }
        binding.emptyDataSetTV.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}


