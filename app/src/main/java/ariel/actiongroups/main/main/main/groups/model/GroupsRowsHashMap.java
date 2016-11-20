package ariel.actiongroups.main.main.main.groups.model;

import android.content.Context;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by home on 6/24/2016.
 */
public class GroupsRowsHashMap {

    private static GroupsRowsHashMap conversationsRowsArray;

    HashMap<String, GroupRow> insideClassContactedUsersHashMap;

    public static GroupsRowsHashMap getInstance() {
        if (conversationsRowsArray == null) {
            conversationsRowsArray = new GroupsRowsHashMap();
        }
        return conversationsRowsArray;
    }

    private GroupsRowsHashMap() {
        insideClassContactedUsersHashMap = new LinkedHashMap<>();
    }

    public HashMap<String, GroupRow> getHashMap() {
        return insideClassContactedUsersHashMap;
    }

    public boolean isGroupInDataBase(String name) {
        if (insideClassContactedUsersHashMap.get(name) != null) {
            return true;
        } else {
            GroupRow groupRow = null; //TODO: use this comment code instead of null: DataBaseManager.getInstance(context).getContactedStylistsReader().getContactConversationRow(name);
            if (groupRow != null) {
                insideClassContactedUsersHashMap.put(name, groupRow);
                return true;
            }
            return false;
        }
    }

}


