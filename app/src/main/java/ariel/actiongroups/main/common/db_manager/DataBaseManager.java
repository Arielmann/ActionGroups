package ariel.actiongroups.main.common.db_manager;

import android.content.Context;
import android.provider.BaseColumns;

public class DataBaseManager {
    private static DataBaseManager dataBase;


    public static abstract class FeedEntry implements BaseColumns {
        public static final String DB_NAME = "mmbdata_db.sqlite";

        //FILES CONTRACT
        public static final String GROUPS_TABLE = "contacted_stylists";
        public static final String CHAT_ITEMS_TABLE = "chat_items";
        public static final String FILE_ID = "entryid";
        public static final String FILE_PATH = "file_path";
        public static final String FILE_BYTES = "file_bytes";
    }


    public static DataBaseManager getInstance(Context context) {
        if (dataBase == null) {
            dataBase = new DataBaseManager(context);
        }
        return dataBase;
    }

    private DataBaseManager(Context context) {
    }
}
