package ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ariel.actiongroups.R;
import ariel.actiongroups.databinding.FragChallengeTabBinding;
import ariel.actiongroups.main.common.challenges.Challenge;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.presenter.ChallengeDescriptionPresenter;
import ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.challengeinfo.presenter.ChallengeInfoPresenterImpl;
import ariel.actiongroups.main.common.courses.states.challengenavigator.view.ChallengeNavigationActivity;

public class ChallengeDescriptionTabFrag extends Fragment implements ChallengeInfoTabView {

    private ChallengeDescriptionPresenter presenter;
    FragChallengeTabBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_challenge_tab, container, false);
        View creatorLayout = binding.getRoot();
        binding.doneButton.setOnClickListener(onDoneButtonClicked);
        presenter = new ChallengeInfoPresenterImpl(this);
        return creatorLayout;
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroyView();
    }

    @Override
    public void setChallengeDataInViews(Challenge challenge) {
        binding.challengeDescriptionTV.setText(challenge.getDescription());
    }

    View.OnClickListener onDoneButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) { //TODO: Mocked method. change it
            presenter.dummyUpdateChallengeData(presenter.getCourse());
            Intent dummyGoToChallengeNavigator = new Intent(getActivity(), ChallengeNavigationActivity.class);
           // NotificationUtils.displayNotificationOnScreen(getContext(), presenter.getCourse(), dummyGoToChallengeNavigator, "Go to new Challenge");
        }
    };
}

/*
    private void initNoMessagesTextViewState() {
        Button addChallenge = (Button) fragmentLayout.findViewById(R.id.createChallengeButton);
        ariel.actiongroups.main.common.utils.GoToScreen goToChallengeCreatorScreen = new GoToScreen(getActivityClass(), ChallengesCreatorActivity.class);
        addChallenge.setOnClickListener(goToChallengeCreatorScreen);
        addChallenge.setVisibility(View.VISIBLE);
    }*/
