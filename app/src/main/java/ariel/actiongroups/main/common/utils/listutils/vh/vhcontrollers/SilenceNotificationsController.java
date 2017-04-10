package ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers;

import android.view.View;

import ariel.actiongroups.main.common.ActionGroupsEntity;

public abstract class SilenceNotificationsController implements View.OnClickListener {

    private ActionGroupsEntity entity;

    public SilenceNotificationsController(ActionGroupsEntity entity) {
        this.entity = entity;
    }

    protected ActionGroupsEntity getEntity(){
        return entity;
    }

    @Override
    public void onClick(View view) {
        entity.setSilenced(!entity.isSilenced());
    }
}
