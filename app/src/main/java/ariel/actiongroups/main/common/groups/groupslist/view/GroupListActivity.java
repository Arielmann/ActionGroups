package ariel.actiongroups.main.common.groups.groupslist.view;

import android.os.Bundle;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.courses.Course;
import ariel.actiongroups.main.common.groups.ActionGroup;

public class GroupListActivity extends GenericGroupListActivity implements OnActionGroupClicked {

    /*
    * will manage the whole process of
    * presenting the conversations that the user created
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);
        //ToolbarFrag toolbar = (ToolbarFrag) getSupportFragmentManager().findFragmentById(R.id.toolbarFragInContactedUsers);
        //toolbar.createDrawer();
    }

    @Override
    public void onActionGroupClicked(ActionGroup group) {
        //TODO: pop options view here
    }
}

