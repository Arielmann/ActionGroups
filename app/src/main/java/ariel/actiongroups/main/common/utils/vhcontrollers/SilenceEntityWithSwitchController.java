package ariel.actiongroups.main.common.utils.vhcontrollers;

import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;
import ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers.SilenceNotificationsController;

public class SilenceEntityWithSwitchController extends SilenceNotificationsController implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = SilenceEntityWithSwitchController.class.getSimpleName();

    public SilenceEntityWithSwitchController(ActionGroupsEntity entity, Switch aSwitch) {
        super(entity);
        aSwitch.setOnCheckedChangeListener(this);
        aSwitch.setChecked(entity.isSilenced());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        getEntity().setSilenced(b);
        Log.d(TAG, "Switch check changed. " + getEntity().getName() + "'s silence notifications mode is set to: "  + getEntity().isSilenced());
    }
}
