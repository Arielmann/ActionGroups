package ariel.actiongroups.main.leader.challenges.challengecreator.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeCreatorBinding;
import ariel.actiongroups.main.common.backend.ServerDataSaver;
import ariel.actiongroups.main.common.challenges.challenge_navigator.SingleChallengeNavigationScreen;
import ariel.actiongroups.main.common.challenges.model.Challenge;

public class ChallengeCreatorFrag extends android.support.v4.app.Fragment {

    public static final String TAG = ChallengeCreatorFrag.class.getName();
    private FragChallengeCreatorBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_creator, container, false);
        View creatorLayout = binding.getRoot();
        binding.goToPreview.setOnClickListener(goToPreview);
        return creatorLayout;
    }

    View.OnClickListener goToPreview = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Challenge challenge = new Challenge();
            ServerDataSaver.getInstance(getContext()).registerNewChallenge(getContext(), challenge);
            Intent goToChallengePreviewActivity = new Intent(getActivity(), SingleChallengeNavigationScreen.class);
            goToChallengePreviewActivity.putExtra(getString(R.string.challenge_text), binding.challengeText.getText());
            startActivity(goToChallengePreviewActivity);
            Log.d(TAG, "Moving to challenge preview activity. challenge: " + binding.challengeText.getText());
        }
    };

    @Override
    public void onDestroyView() {
       // getActivity().getPresenter().onDestroy();
        super.onDestroyView();
    }
}
