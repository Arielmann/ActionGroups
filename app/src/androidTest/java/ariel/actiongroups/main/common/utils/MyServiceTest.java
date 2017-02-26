package ariel.actiongroups.main.common.utils;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import ariel.actiongroups.CustomServiceTestRule;
import ariel.actiongroups.main.common.utils.services.ServiceExample;

@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    @Rule
    public ServiceTestRule myServiceRule = new CustomServiceTestRule();

    @Test
    public void testService() throws TimeoutException {
        myServiceRule.startService(new Intent((InstrumentationRegistry.getTargetContext()),
                ServiceExample.class));
    }

    @Test
    public void testBoundService() throws TimeoutException {
        IBinder binder = myServiceRule.bindService(new Intent(InstrumentationRegistry.getTargetContext(), ServiceExample.class));
        ServiceExample service = ((ServiceExample.LocalBinder) binder).getService();

    }
}