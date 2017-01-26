package ariel.actiongroups.main.common.groups.groupslist.view;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.main.common.groups.ActionGroup;

public class GroupListActivityForResult extends GenericGroupListActivity implements GroupListViewInterface {

    @Override
    public void onGroupClicked(ActionGroup group) {
        EventBus.getDefault().postSticky(group);
        setResult(RESULT_OK);
        finish();
    }
}
