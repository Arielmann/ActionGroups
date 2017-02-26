package ariel.actiongroups.main.common.utils.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceExample extends Service {
    private static final String TAG = ServiceExample.class.getSimpleName();

    public ServiceExample() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Binding MyService");
        return new LocalBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "On start command  called");
        return super.onStartCommand(intent, flags, startId);
    }

    public class LocalBinder extends Binder{
        public ServiceExample getService(){
            return ServiceExample.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
    }
}
