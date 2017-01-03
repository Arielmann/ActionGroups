package ariel.actiongroups.main.common.groups.groups_list.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.FragmentBuilder;

public class GroupListActivity extends AppCompatActivity {

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
        FragmentBuilder builder = new FragmentBuilder(this);
        builder.buildFrag(R.id.groupsInnerRelativeLayout, new GroupsListFrag(), "Groups Presenter");
    }
}

