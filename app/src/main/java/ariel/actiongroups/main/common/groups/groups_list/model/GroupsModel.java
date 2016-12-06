package ariel.actiongroups.main.common.groups.groups_list.model;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ariel.actiongroups.main.common.groups.groups_list.adapter.GroupsAdapter;
import ariel.actiongroups.main.common.groups.groups_list.events.OnContactedUsersLoadedEvent;


/**
 * Created by home on 7/22/2016.
 */
public class GroupsModel {

    /*
    * This singleton model manages the loading of
    * groups and response to runtime changes
    *
    * The model is INDIRECTLY responsible to set the
    * OnGroupClickedMethod, by setting the GroupsAdapter
    * the will directly set it.
    */

    private static GroupsAdapter adapter;
    private static LinearLayoutManager layoutManager;
    private static GroupsModel groupsModel;
    private static List dataSet = new ArrayList();
    private static Map<String, GroupRow> groupsMap;
    private static Context context;

    public static GroupsModel getInstance(Context insideMethodContext) {
        if (groupsModel == null) {
            context = insideMethodContext;
            groupsModel = new GroupsModel(context);
            groupsMap = new LinkedHashMap<>();

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

    public static List initDataSet() { //Since singleton hashMap is use to determine dataSet, each change in the hasmap has to provoke this method
        dataSet.add(new GroupRow( UUID.randomUUID().toString(), "September Lions", "no image", "20.11.16", "Do 100 pushups before dinner"));
        dataSet.add(new GroupRow( UUID.randomUUID().toString(), "October Lions", "no image", "20.11.16", "Do 200 pushups before dinner"));
        dataSet.add(new GroupRow( UUID.randomUUID().toString(), "November Lions", "no image",  "20.11.16", "Do 300 pushups before dinner"));
        dataSet.add(new GroupRow( UUID.randomUUID().toString(), "December Lions", "no image",  "20.11.16", "Do 400 pushups before dinner"));
        dataSet.add(new GroupRow( UUID.randomUUID().toString(), "January Lions", "no image",  "20.11.16", "Do 500 pushups before dinner"));

        EventBus.getDefault().post(new OnContactedUsersLoadedEvent(dataSet));
        return dataSet;
    }

    public List getDataSet() {
        return dataSet;
    }
    ///////////////////////////////////////////////////////////////////////

    public Map<String, GroupRow> getMap() {
        return groupsMap;
    }

    private void insertGroupRowToDataStructures(GroupRow row){
        groupsMap.put(row.getId(), row);
        dataSet.add(row);
    }

    public boolean isGroupInDataBase(String id) {
        if (groupsMap.get(id) != null) {
            return true;
        } else {
            GroupRow groupRow = null; //TODO: use this comment code instead of null: DataBaseManager.getInstance(context).getContactedStylistsReader().getContactConversationRow(name);
            if (groupRow != null) {
                insertGroupRowToDataStructures(groupRow);
                return true;
            }
            return false;
        }
    }

}


