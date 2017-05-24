package ariel.actiongroups.main.common.groups.groupslist.model;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.events.OnGroupRowsLoadedEvent;

public class GroupListModel {

    /*
    * This singleton model manages the loading of
    * groups and response to runtime changes
    */

    private static GroupListModel groupsModel;
    private static List dataSet = new ArrayList();
    private static Map<String, ActionGroup> groupsMap;

    public static GroupListModel getInstance() {
        if (groupsModel == null) {
            groupsModel = new GroupListModel();
            groupsMap = new HashMap<>();
        }
        return groupsModel;
    }

    private GroupListModel() {
    }

    public void setDataSet(List<ActionGroup> dataSet) {
        GroupListModel.dataSet = dataSet;
    }

    public List initDataSet() { //Since singleton hashMap is use to determine dataSet, each change in the hashMap has to provoke this method
        dataSet.add(new ActionGroup());
        dataSet.add(new ActionGroup());
        dataSet.add(new ActionGroup());
        dataSet.add(new ActionGroup());
        dataSet.add(new ActionGroup());
        EventBus.getDefault().post(new OnGroupRowsLoadedEvent(dataSet));
        return dataSet;
    }

    public List getDataSet() {
        return dataSet;
    }

    public Map<String, ActionGroup> getMap() {
        return groupsMap;
    }

    private void insertGroupRowToDataStructures(ActionGroup group){
        groupsMap.put(group.getObjectId(), group);
        dataSet.add(group);
    }

    public boolean isGroupInDataBase(String id) {
        if (groupsMap.get(id) != null) {
            return true;
        } else {
            ActionGroup group = null; //TODO: use this comment code instead of null: DataBaseManager.getInstance(context).getContactedStylistsReader().getActionGroup(name);
            if (group != null) {
                insertGroupRowToDataStructures(group);
                return true;
            }
            return false;
        }
    }

}


