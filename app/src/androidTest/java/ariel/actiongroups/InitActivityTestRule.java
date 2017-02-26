package ariel.actiongroups;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

public class InitActivityTestRule<A extends Activity> extends ActivityTestRule<A> {

    public InitActivityTestRule(Class<A> activityClass) {
        super(activityClass);

    }

    public InitActivityTestRule(Class<A> activityClass, boolean initialTouchMode) {
        super(activityClass, initialTouchMode);
    }

    public InitActivityTestRule(Class<A> activityClass, boolean initialTouchMode, boolean launchActivity) {
        super(activityClass, initialTouchMode, launchActivity);
    }


}
