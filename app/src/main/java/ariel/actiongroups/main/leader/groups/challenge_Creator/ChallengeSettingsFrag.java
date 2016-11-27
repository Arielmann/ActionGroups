package ariel.actiongroups.main.leader.groups.challenge_creator;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import ariel.actiongroups.R;

/**
 * Created by home on 11/13/2016.
 */
public class ChallengeSettingsFrag extends Fragment {

    private static final String CHALLENGE_SETTINGS_FRAG = "Challenge settings frag";
    private TextView challengeDate;
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
        challengeDate = (TextView) layout.findViewById(R.id.challengeDateTV);
        challengeTime = (TextView) layout.findViewById(R.id.challengeTimeTV);
        changeChallengeSendTime.setOnClickListener(onChangeChallengeDate);
        Log.d(CHALLENGE_SETTINGS_FRAG, "View created");
        return layout;
    }

    private View.OnClickListener onChangeChallengeDate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatePickerDialog dialog = new DatePickerDialog(
                    getActivity(), onDateSetListener,  Calendar.getInstance().get(Calendar.YEAR),  Calendar.MONTH,  Calendar.DAY_OF_MONTH);
            dialog.show();
        }
    };

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            onChangeChallengeTime.onClick(null);
            challengeDate.setText("Send on: " +  day + "/" + (month + 1) + "/" + year);
            Log.d(CHALLENGE_SETTINGS_FRAG, "Challenge date is set for " + day + "/" + "" + (month + 1) + "/" + year);
        }
    };

    private View.OnClickListener onChangeChallengeTime = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TimePickerDialog dialog = new TimePickerDialog(getContext(), timeSetListener, Calendar.HOUR + 1, Calendar.MINUTE, true);
            dialog.show();
        }
    };

    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hour, int minute) {
            challengeTime.setText("" + hour + ":" + "" + minute);
            Log.d(CHALLENGE_SETTINGS_FRAG, "Challenge time is set for " + hour + ":" + "" + minute);
        }
    };
}
