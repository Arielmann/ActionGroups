package ariel.actiongroups.main.common.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.List;

import ariel.actiongroups.R;

public class GoToScreen implements View.OnClickListener {

    public Intent getIntent() {
        return goToScreen;
    }

    private Activity activity;
    private Intent goToScreen;
    private String dialogMessage;

    public GoToScreen(Activity activity, Class screen, String dialogMessage) {
        this.activity = activity;
        this.goToScreen = new Intent(activity, screen);
        this.dialogMessage = dialogMessage;
    }

    public GoToScreen(Activity activity, Class screen) {
        this.activity = activity;
        this.goToScreen = new Intent(activity, screen);
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

    public static void setGoToScreenOnClickListener(Button listenerButton, Activity activity, Class targetScreen){
        GoToScreen goToScreen = new GoToScreen(activity, targetScreen);
        listenerButton.setOnClickListener(goToScreen);
    }
}