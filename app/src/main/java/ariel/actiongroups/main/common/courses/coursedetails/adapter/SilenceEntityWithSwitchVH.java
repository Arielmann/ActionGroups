package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;
import ariel.actiongroups.main.common.utils.abstractutils.SilenceNotificationsViewHolder;

class SilenceEntityWithSwitchVH extends SilenceNotificationsViewHolder implements CompoundButton.OnCheckedChangeListener {

    private Switch silenceSwitch;

    SilenceEntityWithSwitchVH(Context context, View itemView, ActionGroupsEntity entity) {
        super(context, itemView, entity);
        silenceSwitch = (Switch) itemView.findViewById(R.id.silenceSwitch);
        silenceSwitch.setChecked(entity.getSilenced());
        silenceSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        silenceSwitch.setChecked(b);
        getEntity().setSilenced(b);
    }

    @Override
    public void setUIDataOnView(int position) {
        silenceSwitch.setChecked(getEntity().getSilenced());
    }
}
