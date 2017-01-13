package ariel.actiongroups.main.common.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import ariel.actiongroups.R;

public class GoToScreen implements View.OnClickListener {

    public Intent getIntent() {
        return goToScreen;
    }

    private Context context;
    private Intent goToScreen;
    private String dialogMessage;

    private GoToScreen(Activity activity, Class screen, String dialogMessage) {
        this.context = activity;
        this.goToScreen = new Intent(activity, screen);
        this.dialogMessage = dialogMessage;
    }

    private GoToScreen(Context context, Class screen) {
        this.context = context;
        this.goToScreen = new Intent(context, screen);
    }

    private GoToScreen(Context context, Class screen, String key, Object data) {
        this.context = context;
        this.goToScreen = new Intent(context, screen);
        this.goToScreen.putExtra(key, (Parcelable) data);
    }

    @Override
    public void onClick(View v) {
        context.startActivity(goToScreen);
    }

    public View.OnClickListener goToScreenWithProgressDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ProgressDialog progressDialog = new ProgressDialog(context,
                    R.style.AppTheme);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(dialogMessage);
            progressDialog.show();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            progressDialog.dismiss();
                            context.startActivity(goToScreen);
                        }
                    }, 2000);
        }
    };

    public static void setGoToScreenOnClickListener(Button button, Context context, Class targetScreen) {
        GoToScreen goToScreen = new GoToScreen(context, targetScreen);
        button.setOnClickListener(goToScreen);
    }

    public static void goToNextScreen(Context context, Class targetScreen) {
        GoToScreen goToScreen = new GoToScreen(context, targetScreen);
        goToScreen.onClick(null);
    }

   /* public static void goToNextScreenWithDataIntent(Activity context, Class targetClass, String key, Object value) {
        Parcels.wrap(value);
        GoToScreen goToScreen = new GoToScreen(context, targetClass, key, value);
        goToScreen.onClick(null);
    }*/
}