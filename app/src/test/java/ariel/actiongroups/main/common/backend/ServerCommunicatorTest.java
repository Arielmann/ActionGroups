package ariel.actiongroups.main.common.backend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ariel.actiongroups.R;

@RunWith(RobolectricTestRunner.class)
public class ServerCommunicatorTest implements ServerDataProviderDelegations.FileUploadDelegate {

    private Context context;

    @Before
    public void setUp() throws Exception {
        context = RuntimeEnvironment.application.getApplicationContext();
    }

    @Test
    public void testRegisterToPushNotificationsCustomChannel() throws Exception {
        ServerCommunicator.getInstance().registerToPushNotificationsCustomChannel("channel");
    }

    @Config(packageName="ariel.actiongroups")
    @Test
    public void testShouldUploadImage() throws Exception {
        Bitmap image = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.female_icon);
        ServerCommunicator.getInstance().uploadImage(context, image);
    }

    @Test
    @Override
    public void uploadImage(Context context, Bitmap image) {

    }
}