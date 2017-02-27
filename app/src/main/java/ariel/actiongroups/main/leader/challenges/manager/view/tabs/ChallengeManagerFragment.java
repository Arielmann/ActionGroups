package ariel.actiongroups.main.leader.challenges.manager.view.tabs;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeManagerBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenter;
import ariel.actiongroups.main.leader.challenges.manager.presenter.ChallengeManagerPresenterImpl;

public class ChallengeManagerFragment extends android.support.v4.app.Fragment {

    public static final String TAG = ChallengeManagerFragment.class.getName();
    private FragChallengeManagerBinding binding;
    private ChallengeManagerPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_manager, container, false);
        presenter = new ChallengeManagerPresenterImpl();
        View creatorLayout = binding.getRoot();
        binding.goToPreview.setOnClickListener(goToPreview);
        return creatorLayout;
    }

    View.OnClickListener goToPreview = new View.OnClickListener() {
        @Override
        public void onClick(View view) { //TODO: crate preview activity prior to saving
            Challenge challenge = new Challenge();
            presenter.saveChallengeDataBases(getContext(), challenge);
            EventBus.getDefault().postSticky(challenge);
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
            Log.d(TAG, "Moving to challenge preview activity. challenge text: " + binding.challengeText.getText());
        }
    };

    @Override
    public void onDestroyView() {
        // getActivity().getPresenter().onDestroy();
        super.onDestroyView();
    }
}
