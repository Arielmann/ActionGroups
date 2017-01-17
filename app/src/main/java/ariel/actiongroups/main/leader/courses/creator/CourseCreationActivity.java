package ariel.actiongroups.main.leader.courses.creator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.view.CourseManagerActivity;

public class CourseCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_creator);
        Button createChallenge = (Button) findViewById(R.id.CreateChallengeInCourseCreatorButton);
        ActivityStarter.setStartActivityOnClickListener(createChallenge, this, CourseManagerActivity.class);
    }
}
