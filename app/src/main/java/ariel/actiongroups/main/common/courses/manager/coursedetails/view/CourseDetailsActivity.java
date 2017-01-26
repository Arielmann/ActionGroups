package ariel.actiongroups.main.common.courses.manager.coursedetails.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivityCourseDetailsBinding;
import ariel.actiongroups.main.common.groups.ActionGroup;
import ariel.actiongroups.main.common.groups.groupslist.view.GroupListActivityForResult;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class CourseDetailsActivity extends AppCompatActivity{

    private static final String TAG = CourseDetailsActivity.class.getName();
    ActivityCourseDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_course_details);
        ActivityStarter.setStartActivityForResultOnClickListener(binding.addGroupsButton, this, GroupListActivityForResult.class );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            ActionGroup group = EventBus.getDefault().removeStickyEvent(ActionGroup.class);
            Log.d(TAG, "Group selected: " + group.toString());
        }
    }
}