package ariel.actiongroups.main.common.courses.manager.singlecoursedetails.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.ActivitySingleCourseDetailsBinding;
import ariel.actiongroups.main.common.groups.groups_list.view.GroupListActivity;
import ariel.actiongroups.main.common.utils.ActivityStarter;

public class SingleCourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySingleCourseDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_single_course_details);
        ActivityStarter.setStartActivityForResultOnClickListener(binding.addGroupsButton, this, GroupListActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            //Add group to course
        }
    }
}
