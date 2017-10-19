package ariel.actiongroups.main.common.resources;

public class AppStrings {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PROFILE_IMAGE_URL = "profileImageUrl";
    public static final String STATE = "state";
    public static final String LEADERS = "leaders";
    public static final String LEADER_NAME = "leaderName";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE_URL = "imageUrl";
    public static final String COMPLETED_BY = "completedBy";
    public static final String LEADER_ID = "leaderId";
    public static final String CREATION_DATE = "creationDate";
    public static final String CHALLENGES = "challenges";
    public static final String MEMBERS = "members";
    public static final String CURRENT_CHALLENGE = "currentChallenge";
    public static final String COURSE = "course";
    private static final String GROUPS = "groups";

    //Relations
    public static final String CHALLANGES_COURSE_RELATION = AppStrings.CHALLENGES + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":n";
    public static final String USER_COURSE_RELATION = AppStrings.MEMBERS + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":n";
    public static final String LEADER_COURSE_RELATION = AppStrings.LEADERS  + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":n";
    public static final String GROUP_COURSE_RELATION = AppStrings.GROUPS + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":n";
    public static final String CURRENT_CHALLENGE_COURSE_RELATION = AppStrings.CURRENT_CHALLENGE + ":" + AppStrings.BACKENDLESS_TABLE_COURSE + ":1";
    public static final String USER_GROUP_RELATION = AppStrings.MEMBERS + ":" + AppStrings.BACKENDLESS_TABLE_ACTION_GROUPS + ":n";

    public static final String USC_GATHER_PAYMENT = "gather_payment";
    public static final String USC_CHALLENGE_NAVIGATION = "challenge_navigation";

    public static final String UPPER_CASE_NAME = "Name";
    public static final String UPPER_CASE_DESCRIPTION = "Description";
    public static final String UPPER_CASE_CHALLENGES = "Challenges";
    public static final String UPPER_CASE_CHALLENGE = "Challenge";
    public static final String UPPER_CASE_CHAT = "Chat";
    public static final String UPPER_CASE_RESULTS = "Results";
    public static final String UPPER_CASE_SETTINGS = "Settings";
    public static final String UPPER_CASE_GROUPS = "Groups";
    public static final String UPPER_CASE_COURSES = "Courses";

    public static final String ALOGLIA_APP_ID = "6LSZGCV9EX";
    public static final String ALOGLIA_ADMIN_API_KEY = "2d2f3336e7547c0239a8a0affc78dbc7";
    public static final String ALGOLIA_SEARCH_API_KEY = "50e3aeb24638b53abd06dc57240531ef";
    public static final String ALGOLIA_USERS_TABLE_NAME = "actiongroups_users";
    public static final String ALGOLIA_COURSES_TABLE_NAME = "actiongroups_courses";
    public static final String ALGOLIA_HITS = "hits";

    public static final String BACKENDLESS_APP_ID = "D0308F31-C627-5E5C-FF98-8F45E1B51200";
    public static final String BACKENDLESS_API_KEY = "1346C6E8-E8B5-BA57-FF1A-CA43DB4D0D00";
    public static final String BACKENDLESS_SENDER_ID = "675632393175";
    public static final String BACKENDLESS_TABLE_COURSE = "Course";
    public static final String BACKENDLESS_TABLE_ACTION_GROUPS = "ActionGroup";
    public static final String BACKENDLESS_TABLE_CHALLENGES = "Backendless_Challenges";
    public static final String BACKENDLESS_TABLE_LEADERS = "Backendless_Leaders";

    public static final String FACEBOOK_APP_ID = "458809844465328";
    public static final String FACEBOOK_CHORME_TABS_ID = "fb458809844465328";


    public static final String EM_UPLOAD_FAILED = "Upload Failed";
}
