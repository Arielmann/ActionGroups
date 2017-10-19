package ariel.actiongroups.main.common.db_manager;

import android.provider.BaseColumns;

public class DataBaseManager {

    public static abstract class FeedEntry implements BaseColumns {
        public static final String DB_NAME = "actiongroups_db.sqlite";

        //FILES CONTRACT
        public static final String GROUPS_TABLE = "groups";
        public static final String MESSAGES_TABLE = "messages";
    }

    private DataBaseManager() {
    }
}
