package ariel.actiongroups.main.main.leader;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import ariel.actiongroups.R;

/**
 * Created by home on 11/13/2016.
 */
public class ChallengeSettingsFrag extends Fragment {

    private TextView challengeTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.frag_challenge_creator_settings, container, false);
        Button changeChallengeSendTime = (Button) layout.findViewById(R.id.changeChallengeSettings);
        challengeTime = (TextView) layout.findViewById(R.id.challengeTimeTV);
        changeChallengeSendTime.setOnClickListener(onChangeChallengeTime);
        return inflater.inflate(R.layout.frag_challenge_creator_settings, container, false);
    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            challengeTime.setText("Sent Time: " + i + "/ " + i1 + "/ " + i2);
        }
    };
        View.OnClickListener onChangeChallengeTime = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(), onDateSetListener, 2016, 11, 14);
                dialog.show();
            }
        };
}
