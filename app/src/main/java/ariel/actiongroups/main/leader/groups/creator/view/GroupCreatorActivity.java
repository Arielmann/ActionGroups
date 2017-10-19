package ariel.actiongroups.main.leader.groups.creator.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGroupCreatorBinding;
import ariel.actiongroups.main.common.courses.search.view.SearchCoursesActivity;
import ariel.actiongroups.main.leader.groups.ActionGroup;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.common.utils.datamanager.DataManager;
import ariel.actiongroups.main.leader.groups.creator.presenter.GroupCreatorPresenter;

public class GroupCreatorActivity extends AppCompatActivity {

    @Inject
    GroupCreatorPresenter presenter;

    private static final String TAG = GroupCreatorActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGroupCreatorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_group_creator);
        Button createGroup = binding.createGroupButton;
        createGroup.setOnClickListener(createGroupOnClick);
        TextView codeTV = binding.groupCodeTV;
        String groupCode = "Leader Name /" + DataManager.getInstance().getUser().getProperty(AppStrings.NAME); //TODO: compare code with all other codes of specific leader to prevent cloning
        codeTV.setText(groupCode);
        Log.d(TAG, TAG + " created");
    }

    View.OnClickListener createGroupOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActionGroup group = new ActionGroup();
            EventBus.getDefault().postSticky(group);
            presenter.saveGroupToDataBases(view.getContext(), group);
            ActivityStarter.startActivity(view.getContext(), SearchCoursesActivity.class);
        }
    };

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
