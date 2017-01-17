package ariel.actiongroups.main.leader.groups.creator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.UUID;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.appinit.AppInit;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groups_list.view.GroupListActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenter;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenterImpl;

public class GroupCreatorActivity extends AppCompatActivity {

    private static final String TAG = GroupCreatorActivity.class.getName();
    GroupCreatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_creator);
        AppInit.InitApp(this); //TODO: Not need to call it here. delete when feature is ready
        presenter = new GroupCreatorPresenterImpl();
        Button createGroup = (Button) findViewById(R.id.createGroupButton);
        createGroup.setOnClickListener(createGroupOnClick);
        TextView codeTV = (TextView) findViewById(R.id.groupCodeTV);
        String groupCode = "Leader Name /" + UUID.randomUUID().toString(); //TODO: compare code with all other codes of specific leader to prevent cloning
        codeTV.setText(groupCode);
        Log.d(TAG, TAG + " created");
    }

    View.OnClickListener createGroupOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActionGroup group = new ActionGroup();
            EventBus.getDefault().postSticky(group);
            presenter.saveGroupToDataBases(view.getContext(), group);
            ActivityStarter.startActivity(view.getContext(), GroupListActivity.class);
        }
    };

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
