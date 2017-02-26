package ariel.actiongroups;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.test.rule.ServiceTestRule;
import android.util.Log;

import java.util.concurrent.TimeoutException;

public class CustomServiceTestRule extends ServiceTestRule {

    private static final String TAG = CustomServiceTestRule.class.getSimpleName();

    @Override
    public void startService(@NonNull Intent intent) throws TimeoutException {
        super.startService(intent);
        Log.d(TAG, "Service started");
    }

    @Override
    protected void beforeService() {
        Log.d(TAG, "Work before service starts");
        super.beforeService();
    }

    @Override
    protected void afterService() {
        Log.d(TAG, "Work after service starts");
        super.afterService();
    }

    @Override
    public IBinder bindService(@NonNull Intent intent) throws TimeoutException {
        Log.d(TAG, "Binding service");
        return super.bindService(intent);
    }
}
