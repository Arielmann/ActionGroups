package ariel.actiongroups.main.leader.challenges.manager.view.tabs;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeManagerBinding;
import ariel.actiongroups.main.common.app.ActionGroupsApplication;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.challenges.manager.events.OnChallengesEditedEvent;
import ariel.actiongroups.main.leader.challenges.manager.models.ChallengeEditorModel;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenter;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;
import ariel.actiongroups.main.leader.courses.manager.singlecourse.model.CourseManagerModel;
import biz.kasual.materialnumberpicker.MaterialNumberPicker;

public class ChallengeEditorFragment extends android.support.v4.app.Fragment {

    public static final String TAG = ChallengeEditorFragment.class.getName();
    private List<Challenge> challenges = CourseManagerModel.getInstance().getChallenges();
    private FragChallengeManagerBinding binding;
    private ChallengeManagerPresenter presenter;
    private Challenge challenge;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        challenge = ChallengeEditorModel.getInstance().getChallenge(); //TODO: Create presenter
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_manager, container, false);
        presenter = new ChallengeManagerPresenterImpl();
        View creatorLayout = binding.getRoot();
        binding.doneButton.setOnClickListener(goToPreview);
        binding.changeNumber.setOnClickListener(openNumberPicker);
        return creatorLayout;
    }

    View.OnClickListener goToPreview = new View.OnClickListener() {
        @Override
        public void onClick(View view) { //TODO: maybe crate preview activity prior to saving
            Challenge challenge = modifyCurrentChallengeFromInput();
            presenter.saveChallengeDataBases(getContext(), challenge);
            EventBus.getDefault().post(new OnChallengesEditedEvent());
            getActivity().finish();
            Log.d(TAG, "Moving to course manager activity. challenge objective: " + binding.mainObjective.getText());
        }
    };

    View.OnClickListener openNumberPicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popChallengeNumberPickerAlert();
        }
    };

    private Challenge modifyCurrentChallengeFromInput() {
        challenge.setName(binding.name.getText().toString());
        challenge.setDescription(binding.explanation.getText().toString());
        List<String> objectives = new ArrayList<>();
        objectives.add(binding.mainObjective.getText().toString());
        challenge.setObjectives(objectives);
        return challenge;
    }

    private MaterialNumberPicker initChallengeNumberPicker() {
        return new MaterialNumberPicker.Builder(getContext())
                .minValue(1)
                .maxValue(challenges.size() - 1)
                .defaultValue(challenge.getPositionInCourse())
                .backgroundColor(Color.WHITE)
                .separatorColor(Color.TRANSPARENT)
                .textColor(Color.BLACK)
                .textSize(20)
                .enableFocusability(false)
                .wrapSelectorWheel(true)
                .build();
    }

    private void popChallengeNumberPickerAlert() {
        final MaterialNumberPicker numberPicker = initChallengeNumberPicker();
        new AlertDialog.Builder(getContext())
                .setTitle("Choose challenge number")
                .setView(numberPicker)
                .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar.make(binding.fragChallengeManagerLayout, "Challenge's position " + numberPicker.getValue(), Snackbar.LENGTH_SHORT).show();
                        binding.challengeNumberIntTV.setText(String.valueOf(numberPicker.getValue()));
                        presenter.changeChallengePositionInArray(challenges.indexOf(ChallengeEditorModel.getInstance().getChallenge()), numberPicker.getValue());
                    }
                })
                .show();
    }

    @Override
    public void onDestroyView() {
        // getActivityClass().getPresenter().onDestroy();
        super.onDestroyView();
    }
}
