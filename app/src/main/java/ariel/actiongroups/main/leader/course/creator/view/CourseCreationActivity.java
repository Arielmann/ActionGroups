package ariel.actiongroups.main.leader.course.creator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.GoToScreen;

public class CourseCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_creator);
        Button createChallenge = (Button) findViewById(R.id.CreateChallengeInCourseCreatorButton);
        GoToScreen.setGoToScreenOnClickListener(createChallenge, this, CourseOverviewActivity.class);
    }
}
