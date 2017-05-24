package ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers;

import android.view.View;

import ariel.actiongroups.main.common.ActionGroupsEntity;

abstract class SilenceNotificationsVHController implements View.OnClickListener {

    private ActionGroupsEntity entity;

    SilenceNotificationsVHController(ActionGroupsEntity entity) {
        this.entity = entity;
    }

    ActionGroupsEntity getEntity(){
        return entity;
    }

    @Override
    public void onClick(View view) {
        entity.setSilenced(!entity.isSilenced());
    }
}
