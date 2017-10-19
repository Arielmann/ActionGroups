package ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers;

import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import ariel.actiongroups.main.common.utils.listutils.ListPresentable;

public class SilenceEntityWithSwitchVHController extends SilenceNotificationsVHController implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = SilenceEntityWithSwitchVHController.class.getSimpleName();

    public SilenceEntityWithSwitchVHController(ListPresentable data, Switch aSwitch) {
        super(data);
        aSwitch.setOnCheckedChangeListener(this);
        aSwitch.setChecked(data.isSilenced());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        getData().setSilenced(b);
        Log.d(TAG, "Switch check changed. " + getData().getName() + "'s silence notifications mode is set to: "  + getData().isSilenced());
    }
}
