package ariel.actiongroups.main.leader.groups.groupslist.view;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.main.leader.groups.ActionGroup;

public class GroupListActivityForResult extends GenericGroupListActivity implements OnActionGroupClicked {

    @Override
    public void onActionGroupClicked(ActionGroup group) {
        EventBus.getDefault().postSticky(group);
        setResult(RESULT_OK);
        finish();
    }
}
