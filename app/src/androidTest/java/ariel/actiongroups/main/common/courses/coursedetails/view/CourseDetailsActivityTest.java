package ariel.actiongroups.main.common.courses.coursedetails.view;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ariel.actiongroups.InitActivityTestRule;
import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.coursedetails.presenter.CourseDetailsPresenterImpl;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class CourseDetailsActivityTest {

    private static final String TAG = CourseDetailsActivityTest.class.getSimpleName();

    @Rule
    public InitActivityTestRule<CourseDetailsActivity> courseDetailsActivityActivityTestRule
            = new InitActivityTestRule<>(CourseDetailsActivity.class);

    @Test
    public void onCreateTest() throws Exception {
        CourseDetailsActivity activity = courseDetailsActivityActivityTestRule.getActivity();
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        Assert.assertNotNull(recyclerView);
        Assert.assertTrue(recyclerView.isShown());
        Assert.assertNull(activity.findViewById(R.id.challengeCardDescription));
    }

    @Before
    public void setUp(){
        CourseDetailsPresenterImpl presenter = mock(CourseDetailsPresenterImpl.class);
    }

    @Test
    public void testPressBackButton(){
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();
    }

    @Test
    public void testScreenOrientation() throws RemoteException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if(device.isScreenOn()){
            device.setOrientationLeft();
            device.openNotification();
        }
    }

    @Test
    public void testCreatingMockButton(){
        Button mockButton = mock(Button.class);
        mockButton.callOnClick();
    }

    @Test
    public void testEspresso(){
        ViewInteraction viewInteraction = Espresso.onView(allOf(withId(R.id.entityTitle)))  ;
        closeSoftKeyboard();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        viewInteraction.perform(ViewActions.replaceText("Hello"));
    }
/*
    @Test
    public void onActivityResult() throws Exception {

    }

    @Test
    public void onActionGroupClicked() throws Exception {

    }*/

}