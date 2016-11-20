package ariel.actiongroups.main.main.main.groups.fragments;

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
import ariel.actiongroups.main.main.main.groups.events.OnContactedUsersLoadedEvent;
import ariel.actiongroups.main.main.main.groups.model.GroupRow;
import ariel.actiongroups.main.main.main.groups.model.GroupsModel;

/**
 * Created by home on 6/19/2016.
 */
public class GroupsPresenterFrag extends Fragment {
    private RecyclerView recyclerView;
    private TextView noContactedUsersMessage;

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
        GroupsModel contactedUsersModel = GroupsModel.getInstance(getContext());
        initNoMessagesTextViewState(contactedUsersModel.getDataSet());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recyclerViewLayout = inflater.inflate(R.layout.frag_recycler_view, null);
        recyclerView = (RecyclerView) recyclerViewLayout.findViewById(R.id.recyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        GroupsModel model = GroupsModel.getInstance(getContext());
        recyclerView.setLayoutManager(model.getLayoutManager());
        recyclerView.setAdapter(model.getAdapter());
        noContactedUsersMessage = (TextView) recyclerViewLayout.findViewById(R.id.noContactedUsersTextViewInRecyclerView);
        return recyclerViewLayout;
    }

    @Subscribe
    public void onContactedUsersLoadedEvent(OnContactedUsersLoadedEvent event) {
        initNoMessagesTextViewState(event.groupRows);
    }

    private void initNoMessagesTextViewState(List<GroupRow> contactedUsersRows) {
        if (contactedUsersRows.size() == 0) {
            noContactedUsersMessage.setVisibility(View.VISIBLE);
        } else {
            noContactedUsersMessage.setVisibility(View.GONE);
        }
    }
}

