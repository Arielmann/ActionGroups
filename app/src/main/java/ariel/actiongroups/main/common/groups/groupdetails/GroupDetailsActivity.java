package ariel.actiongroups.main.common.groups.groupdetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGroupInfoScreenBinding;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;

public class GroupDetailsActivity extends AppCompatActivity {

    ActivityGroupInfoScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_group_info_screen);
        ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        binding.groupInfoGroupNameTV.setText(group.getName());
        ActivityStarter.setStartActivityOnClickListener(binding.createChallengeButton, this, ChallengeEditorActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
