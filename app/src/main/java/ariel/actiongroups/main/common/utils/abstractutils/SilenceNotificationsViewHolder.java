package ariel.actiongroups.main.common.utils.abstractutils;

import android.content.Context;
import android.view.View;

import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;

public abstract class SilenceNotificationsViewHolder extends GenericViewHolder implements View.OnClickListener {

    private ActionGroupsEntity entity;

    public SilenceNotificationsViewHolder(Context context, View itemView, ActionGroupsEntity entity) {
        super(itemView);
        this.entity = entity;
    }

    protected ActionGroupsEntity getEntity(){
        return entity;
    }

    @Override
    public void onClick(View view) {
        entity.setSilenced(!entity.getSilenced());
    }
}
