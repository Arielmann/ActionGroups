package ariel.actiongroups.main.main.main.groups.model;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.groups.adapter.GroupsAdapter;
import ariel.actiongroups.main.main.main.groups.events.OnContactedUsersLoadedEvent;

/**
 * Created by home on 7/22/2016.
 */
public class GroupsModel {

    /*
    * This singleton model manages the loading of
    * contacted users and response to runtime changes
    *
    * The model is INDIRECTLY responsible to set the
    * OnContactedUserClickedMethod, by setting the ContactedUsersAdapter
    * the will directly set it.
    */

    private static GroupsAdapter adapter;
    private static LinearLayoutManager layoutManager;
    private static GroupsModel groupsModel;
    private static GroupRow[] dataSet = new GroupRow[3];
    private static Context context;

    public static GroupsModel getInstance(Context insideMethodContext) {
        if (groupsModel == null) {
            context = insideMethodContext;
            groupsModel = new GroupsModel(context);
        }
        layoutManager = (new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        return groupsModel;
    }

    private GroupsModel(Context context) {
        layoutManager = (new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public GroupsAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter() {
        if(adapter == null) {
            initDataSet();
            adapter = new GroupsAdapter(context, dataSet);
        }
    }

    public static GroupRow[] initDataSet() { //Since singleton hashMap is use to determine dataSet, each change in the hasmap has to provoke this method
        HashMap<String, GroupRow> hashMap = GroupsRowsHashMap.getInstance().getHashMap();
        dataSet[0] = new GroupRow("September Lions", "no image", "Do 100 pushups before dinner", "20.11.16");
        dataSet[1] = new GroupRow("October Lions", "no image", "Do 200 pushups before dinner", "20.11.16");
        dataSet[2] = new GroupRow("November Lions", "no image", "Do 300 pushups before dinner", "20.11.16");
        if (!hashMap.isEmpty()) {
            dataSet = (GroupRow[]) hashMap.entrySet().toArray();
        }
        EventBus.getDefault().post(new OnContactedUsersLoadedEvent(dataSet));
        return dataSet;
    }

    public GroupRow[] getDataSet() {
        return dataSet;
    }
}
