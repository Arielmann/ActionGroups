package ariel.actiongroups.main.client.groups.groups_presenter.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import ariel.actiongroups.main.client.groups.groups_presenter.model.ActionGroup;
import ariel.actiongroups.main.common.db_manager.DataBaseManager;

/**
 * Created by home on 7/26/2016.
 */
public class GroupsTableWriter extends SQLiteOpenHelper {

    /*
    * The Writer is called when a the user sends
    * his first message to a newly chosen Stylist
    * within the ChatScreen OR when he get's a new
    * message from a stylist.(for now, checks if
    * its a new stylist saveAddressedUserToTable() method located
    * within the ChatScreen controllers is called every time the user
    * sends any kind of message)
    * */

    private static final String GROUPS_TABLE = DataBaseManager.FeedEntry.GROUPS_TABLE;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_IMAGE_PATH = "image";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_COMPANY = "company";
    private static final String KEY_WEBSITE = "website";
    private static final String KEY_TOKEN = "gcm_token";

    public GroupsTableWriter(Context context, int version) {
        super(context, DataBaseManager.FeedEntry.DB_NAME, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        getTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GROUPS_TABLE);
        onCreate(db);
    }

    private void getTable(SQLiteDatabase db) {
        // db.execSQL("DROP TABLE IF EXISTS " + GROUPS_TABLE);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + GROUPS_TABLE + //TODO: SHOULD BE CALLED IN ONCREATE()!
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT_LEFT NOT NULL, " +
                "location TEXT_LEFT, " +
                "image TEXT_LEFT NOT NULL, " +
                "description TEXT_LEFT, " +
                "company TEXT_LEFT, " +
                "website TEXT_LEFT, " +
                "token TEXT_LEFT NOT NULL)");
    }

    public void addContactToTable(final Context context, final ActionGroup[] groups, final String lastMessageDate, final String lastMessage) {

        new AsyncTask<ActionGroup, Void, ActionGroup>() {

            @Override
            protected ActionGroup doInBackground(ActionGroup... groupInArray) {
                SQLiteDatabase db = getWritableDatabase(); //TODO: DO WITH AsyncTask
                db.execSQL("CREATE TABLE IF NOT EXISTS " + GROUPS_TABLE + //TODO: SHOULD BE CALLED IN ONCREATE()!
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT_LEFT NOT NULL, " +
                        "location TEXT_LEFT, " +
                        "image TEXT_LEFT NOT NULL, " +
                        "description TEXT_LEFT, " +
                        "company TEXT_LEFT, " +
                        "website TEXT_LEFT, " +
                        "token TEXT_LEFT NOT NULL)");

                ContentValues values = new ContentValues();
/*
                try {
                    values.put(KEY_NAME, groupInArray[0].getName());
                } catch (NullPointerException e) {
                    throw new ClassCastException(getClass().toString()
                            + "Addressed stylist passed from contactedUsersFrag is NULL!,  ");
                }
                //Create the profile image file on device, based on stylist bitmap
                ImageUtils.setUserImageFile(context,
                        groupInArray[0],
                        groupInArray[0].getUserImageBitmap(),
                        groupInArray[0].getName());

                values.put(KEY_LOCATION, groupInArray[0].getLocation());
                values.put(KEY_IMAGE_PATH, groupInArray[0].getImage());
                values.put(KEY_DESCRIPTION, groupInArray[0].getDescription());
                values.put(KEY_COMPANY, groupInArray[0].getCompany());
                values.put(KEY_WEBSITE, groupInArray[0].getWebsite());
                values.put(KEY_TOKEN, groupInArray[0].getGcmToken());
                db.insert(GROUPS_TABLE, null, values);
                EventBus.getDefault().postSticky(db);*/
                return groupInArray[0];
            }

            @Override
            protected void onPostExecute(ActionGroup group) {
                /*//add contact row for ContactedUsesHashMap
                GroupsModel model = GroupsModel.getInstance(context);
                GroupRow gropudRow = new GroupRow(group.getName(), group.getImage(), lastMessageDate, lastMessage);
                gropudRow.setBitmap(group.getUserImageBitmap()); // bitmap is already defined
                ContactedUsersRowsHashMap.getInstance().getHashMap().put(group.getName(), gropudRow);
                model.getDataSet().add(gropudRow);
                EventBus.getDefault().post(new OnContactedUsersLoadedEvent(model.getDataSet()));
                GroupsModel.getInstance(context).getAdapter().notifyDataSetChanged();
                //TODO: find a way to close the db without crashing*/
            }
        }.execute(groups);
    }
}