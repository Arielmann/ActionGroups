package ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers;

import android.view.View;

import ariel.actiongroups.main.common.utils.listutils.ListPresentable;

abstract class SilenceNotificationsVHController implements View.OnClickListener {

    private ListPresentable data;

    SilenceNotificationsVHController(ListPresentable data) {
        this.data = data;
    }

    ListPresentable getData(){
        return data;
    }

    @Override
    public void onClick(View view) {
        data.setSilenced(!data.isSilenced());
    }
}
