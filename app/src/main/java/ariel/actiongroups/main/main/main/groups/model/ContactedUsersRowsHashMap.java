package ariel.actiongroups.main.main.main.groups.model;

import android.content.Context;

import java.util.HashMap;
import java.util.LinkedHashMap;

import ariel.actiongroups.main.main.db_manager.DataBaseManager;

/**
 * Created by home on 6/24/2016.
 */
public class ContactedUsersRowsHashMap {

    private static ContactedUsersRowsHashMap conversationsRowsArray;

    LinkedHashMap<String, GroupRow> insideClassContactedUsersHashMap;

    public static ContactedUsersRowsHashMap getInstance() {
        if (conversationsRowsArray == null) {
            conversationsRowsArray = new ContactedUsersRowsHashMap();
        }
        return conversationsRowsArray;
    }

    private ContactedUsersRowsHashMap() {
        insideClassContactedUsersHashMap = new LinkedHashMap<>();
    }

    public HashMap<String, GroupRow> getHashMap() {
        return insideClassContactedUsersHashMap;
    }

    public boolean userIsInDataBase(Context context, String addressedUserName) {
        if (insideClassContactedUsersHashMap.get(addressedUserName) != null) {
            return true;
        } else {
            GroupRow userRow = null; // DataBaseManager.getInstance(context).getContactedStylistsReader().getContactConversationRow(addressedUserName);
            if (userRow != null) {
                insideClassContactedUsersHashMap.put(addressedUserName, userRow);
                return true;
            }
            return false;
        }
    }

}


