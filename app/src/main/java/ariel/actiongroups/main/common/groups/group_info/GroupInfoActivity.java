package ariel.actiongroups.main.common.groups.group_info;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityGroupInfoScreenBinding;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.utils.GoToScreen;
import ariel.actiongroups.main.leader.challenges.creator.view.CreateChallengeActivity;

public class GroupInfoActivity extends AppCompatActivity {

    ActivityGroupInfoScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_group_info_screen);
        ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
        binding.groupInfoGroupNameTV.setText(group.getName());
        GoToScreen.setGoToScreenOnClickListener(binding.createChallengeButton, this, CreateChallengeActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
