package ariel.actiongroups.main.common.utils.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TestServiceExample extends Service {
    private static final String TAG = TestServiceExample.class.getSimpleName();

    public TestServiceExample() {
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
        public TestServiceExample getService(){
            return TestServiceExample.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
    }
}