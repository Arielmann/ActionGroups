package ariel.actiongroups.main.main.main.groups.model;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static List<GroupRow> dataSet = new ArrayList();
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

    public static List<GroupRow> initDataSet() { //Since singleton hashMap is use to determine dataSet, each change in the hasmap has to provoke this method
        dataSet.clear();
        HashMap<String, GroupRow> hashMap = ContactedUsersRowsHashMap.getInstance().getHashMap();
        if (!hashMap.isEmpty()) {
            for (Map.Entry<String, GroupRow> map : hashMap.entrySet()) {
                dataSet.add(map.getValue());
            }
        }
        EventBus.getDefault().post(new OnContactedUsersLoadedEvent(dataSet));
        return dataSet;
    }

    public List getDataSet() {
        return dataSet;
    }
}
