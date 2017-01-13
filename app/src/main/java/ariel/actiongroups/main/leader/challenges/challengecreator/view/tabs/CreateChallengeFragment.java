package ariel.actiongroups.main.leader.challenges.challengecreator.view.tabs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeCreatorBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.leader.challenges.challengecreator.presenters.CreateChallengePresenter;
import ariel.actiongroups.main.leader.challenges.challengecreator.presenters.CreateChallengePresenterImpl;

public class CreateChallengeFragment extends android.support.v4.app.Fragment {

    public static final String TAG = CreateChallengeFragment.class.getName();
    private FragChallengeCreatorBinding binding;
    private CreateChallengePresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_creator, container, false);
        presenter = new CreateChallengePresenterImpl();
        View creatorLayout = binding.getRoot();
        binding.goToPreview.setOnClickListener(goToPreview);
        return creatorLayout;
    }

    View.OnClickListener goToPreview = new View.OnClickListener() {
        @Override
        public void onClick(View view) { //TODO: crate preview activity prior to saving
            Challenge challenge = new Challenge();
            presenter.saveChallengeDataBases(getContext(), challenge);
            EventBus.getDefault().postSticky(challenge); //Use it in ChallengeNavigationScreen
            //GoToScreen.goToNextScreen(getActivity(), CourseOverviewActivity.class);
            getActivity().setResult(-1);
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
