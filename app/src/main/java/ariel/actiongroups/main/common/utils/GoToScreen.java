package ariel.actiongroups.main.common.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import ariel.actiongroups.R;

public class GoToScreen implements View.OnClickListener {

    public Intent getIntent() {
        return goToScreen;
    }

    private Activity activity;
    private Intent goToScreen;
    private String dialogMessage;

    private GoToScreen(Activity activity, Class screen, String dialogMessage) {
        this.activity = activity;
        this.goToScreen = new Intent(activity, screen);
        this.dialogMessage = dialogMessage;
    }

    private GoToScreen(Activity activity, Class screen) {
        this.activity = activity;
        this.goToScreen = new Intent(activity, screen);
    }

    private GoToScreen(Activity activity, Class screen, String key, Object data) {
        this.activity = activity;
        this.goToScreen = new Intent(activity, screen);
        this.goToScreen.putExtra(key, (Parcelable) data);
    }

    @Override
    public void onClick(View v) {
        activity.startActivity(goToScreen);
    }

    public View.OnClickListener goToScreenWithProgressDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ProgressDialog progressDialog = new ProgressDialog(activity,
                    R.style.AppTheme);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(dialogMessage);
            progressDialog.show();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            progressDialog.dismiss();
                            activity.startActivity(goToScreen);
                        }
                    }, 2000);
        }
    };

    public static void setGoToScreenOnClickListener(Button button, Activity activity, Class targetScreen) {
        GoToScreen goToScreen = new GoToScreen(activity, targetScreen);
        button.setOnClickListener(goToScreen);
    }

    public static void goToNextScreen(Activity activity, Class targetScreen) {
        GoToScreen goToScreen = new GoToScreen(activity, targetScreen);
        goToScreen.onClick(null);
    }

   /* public static void goToNextScreenWithDataIntent(Activity activity, Class targetClass, String key, Object value) {
        Parcels.wrap(value);
        GoToScreen goToScreen = new GoToScreen(activity, targetClass, key, value);
        goToScreen.onClick(null);
    }*/
}