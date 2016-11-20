package ariel.actiongroups.main.main.main.groups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ariel.actiongroups.R;
import ariel.actiongroups.main.main.main.groups.fragments.GroupsPresenterFrag;
import ariel.actiongroups.main.main.support_classes.handlers.FragmentBuilder;

public class GroupsScreen extends AppCompatActivity {

    /*
    * will manage the whole process of
    * presenting the conversations that the user created
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        //ToolbarFrag toolbar = (ToolbarFrag) getSupportFragmentManager().findFragmentById(R.id.toolbarFragInContactedUsers);
        //toolbar.createDrawer();
        FragmentBuilder builder = new FragmentBuilder(this);
        builder.buildFrag(R.id.groupsInnerRelativeLayout, new GroupsPresenterFrag(), "Groups Presenter");
    }
}
