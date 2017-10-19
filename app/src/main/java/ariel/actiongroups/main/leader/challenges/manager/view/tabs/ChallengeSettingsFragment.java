package ariel.actiongroups.main.leader.challenges.manager.view.tabs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeCreatorSettingsBinding;
import ariel.actiongroups.main.common.challenges.User;
import ariel.actiongroups.main.leader.challenges.manager.models.ChallengeEditorModel;

public class ChallengeSettingsFragment extends Fragment {

    private static final String TAG = ChallengeSettingsFragment.class.getSimpleName();

    private FragChallengeCreatorSettingsBinding binding;
    private User currentChallenge;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.frag_challenge_creator_settings, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_creator_settings, container, false);
        binding.changeChallengeSettings.setOnClickListener(onChangeChallengeDate);
        Log.d(TAG, "View created");
        currentChallenge = ChallengeEditorModel.getInstance().getChallenge();
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
            String challengeTimeString = "Start time: " + day + "/" + (month + 1) + "/" + year;
            binding.challengeDateTV.setText(challengeTimeString);
            Log.d(TAG, "User " + challengeTimeString);
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
            binding.challengeTimeTV.setText("" + hour + ":" + "" + minute);
            Log.d(TAG, "User time is set for " + hour + ":" + "" + minute);
        }
    };
}
