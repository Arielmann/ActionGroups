package ariel.actiongroups.main.leader.courses.creator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.algolia.search.saas.Client;
import com.algolia.search.saas.Index;

import javax.inject.Inject;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.resources.AppStrings;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.view.CourseManagerActivity;

public class CourseCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_creator);
        Button createChallenge = (Button) findViewById(R.id.createCourseButton);
        createChallenge.setOnClickListener(onCreateButonClicked);
    }

    private View.OnClickListener onCreateButonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActivityStarter.startActivity(v.getContext(), CourseManagerActivity.class);
        }
    };
}
