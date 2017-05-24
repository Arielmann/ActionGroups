package ariel.actiongroups.main.common.utils.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.resources.AppIntegers;
import ariel.actiongroups.main.common.resources.AppStrings;

public class NotificationUtils {

    private static final String TAG = NotificationUtils.class.getSimpleName();


    public static void displayNotificationOnScreen(Context context, Course course, Intent goToScreen, String message) {
        EventBus.getDefault().postSticky(course);
        NotificationCompat.InboxStyle inbox = new NotificationCompat.InboxStyle();
        //addNewLineToNotiInbox();
        Log.d(TAG, "started notification displaying method");
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, AppIntegers.ZERO, goToScreen, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.pink_thumb_up)
                .setContentTitle(course.getName())
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setStyle(inbox)
                .setGroup(AppStrings.UPPER_CASE_CHALLENGE)
                .setGroupSummary(true)
                .setAutoCancel(true)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // Play default notification sound
        notification.defaults |= Notification.DEFAULT_SOUND;

        // Vibrate if vibrate is enabled
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        //Note: Generate unique notification id for multiple notifications display
        notificationManager.notify(AppIntegers.ONE, notification);
    }

 /*   private void addNewLineToNotiInbox() {
        for (String message : messages) {
            inbox.addLine(message);
        }
        if (messages.size() > 1) {
            inbox.setBigContentTitle(messages.size() + " new messages");
        }
    }*/
}
