package ariel.actiongroups.main.common.utils.SharedPrefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;


import java.util.HashMap;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.image_utils.ImageUtils;

/**
 * Created by home on 5/21/2016.
 */
public class SharedPrefManager {

    /*
    * Shared preferences of this app saves profile info and has
    * id
    * name
    * password
    * email
    * location
    * description
    * profile image file path
    * profile image url
    * gcm token
    * device screen's height
    * device screen's width
    *
    * these properties will be gettable throughout this class
    * */

    // private static ImageArray sharedPrefs = new ImageArray();
    private static SharedPrefManager sharedPrefs;
    private static Resources res;
    private SharedPreferences insideSharedPref;
    private int notificationsCounter;
    private Bitmap userImageBitmap = ImageUtils.defaultProfileImage;
    private String ACCOUNT_INFO = "Account info";

    //creates the only instance
    private SharedPrefManager(Context context) {
        insideSharedPref = context.getSharedPreferences(ACCOUNT_INFO, Context.MODE_PRIVATE);
    }

    // prevents creating of instances
    public static SharedPrefManager getInstance(Context context) { // create a static common database
        if (sharedPrefs == null) {
            sharedPrefs = new SharedPrefManager(context);
            res = context.getResources();
        }
        return sharedPrefs;
    }

    public SharedPreferences getSharedPrefs() {
        return insideSharedPref;
    }

    public int getUserId() {
        return insideSharedPref.getInt("id", -1);
    }

    public String getUserName() {
        return insideSharedPref.getString("name", "user name error");
    }

    public String getUserPassword() {
        return insideSharedPref.getString("password", null);
    }

    public String getUserEmail() {
        return insideSharedPref.getString(res.getString(R.string.email), null);
    }

    public String getUserLocation() {
        return insideSharedPref.getString("location", "location error");
    }

    public String getProfileImagePath() {
        return insideSharedPref.getString("profileImageFilePath", "profile image file path error");
    }

    public String getProfileImageUrl() {
        return insideSharedPref.getString("profileImageUrl", "profile image url error");
    }

    public String getUserDescription() {
        return insideSharedPref.getString("description", "description error");
    }

    public String getUserGcmToken() {
        return insideSharedPref.getString("gcmToken", "gcm token error");
    }

    public int getUserDeviceScreenHeight() {
        return insideSharedPref.getInt("deviceScreenHeight", -1);
    }

    public int getUserDeviceScreenWidth() {
        return insideSharedPref.getInt("deviceScreenWidth", -1);
    }

    public Bitmap getUserImageBitmap() {
        return userImageBitmap;
    }

    public void setUserImageBitmap(Bitmap userImageBitmap) {
        this.userImageBitmap = userImageBitmap;
    }

    public void saveStringInfoToSharedPreferences(final Context context, final String key, final String value) {
        AsyncTask saveToSharedPref = new AsyncTask() {

            @Override
            protected Object doInBackground(Object... params) {
                SharedPreferences.Editor editor = SharedPrefManager.getInstance(context).getSharedPrefs().edit()    //SharedPrefManager is a LOCAL class
                        .putString(key, value);
                editor.commit();
                return null;
            }
        };
        saveToSharedPref.execute();
    }


    public void saveIntInfoToSharedPreferences(final Context context, final String key, final int value) {
        AsyncTask saveToSharedPref = new AsyncTask() {

            @Override
            protected Object doInBackground(Object... params) {
                SharedPreferences.Editor editor = SharedPrefManager.getInstance(context).getSharedPrefs().edit()    //SharedPrefManager is a LOCAL class
                        .putInt(key, value);
                editor.commit();
                return null;
            }
        };
        saveToSharedPref.execute();
    }

    public HashMap<String, String> initSharedPrefData() {
        HashMap<String, String> sharedPrefData = new HashMap<>();
        sharedPrefData.put("name", insideSharedPref.getString("name", "error"));
        sharedPrefData.put("password", insideSharedPref.getString("password", "error"));
        //sharedPrefData.put("email",  insideSharedPref.getString("email", "error")); //Not yet active
        sharedPrefData.put("location", insideSharedPref.getString("location", "error"));
        sharedPrefData.put("profileImageFilePath", insideSharedPref.getString("profileImageFilePath", "error"));
        sharedPrefData.put("profileImageUrl", insideSharedPref.getString("profileImageUrl", "error"));
        sharedPrefData.put("description", insideSharedPref.getString("description", "error"));
        sharedPrefData.put("gcmToken", insideSharedPref.getString("gcmToken", "error"));
        return sharedPrefData;
    }

    public int getNotificationsCounter() {
        return notificationsCounter++;
    }

    public String getProfileImagesDir() {
        return "/Make_Me_Beautiful/Contacts";
    }

    @Override
    public String toString() {
        return "User Details: " +
                " Name: " + getUserName() +
                " Location: " + getUserLocation() +
                " Description: " + getUserDescription() +
                " Profile image file: " + getProfileImagePath() +
                " Profile image url: " + getProfileImageUrl() +
                " Gcm Token: " + getUserGcmToken() +

                " Device details: " +
                " Screen Height: " + getUserDeviceScreenHeight() +
                " Screen Width: " + getUserDeviceScreenWidth();
    }
}

