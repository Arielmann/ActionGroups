package ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.presenter.ChallengeInfoPresenter;
import ariel.actiongroups.main.common.challenges.challenge_navigator.tabs.challengeinfo.presenter.ChallengeInfoPresenterImpl;
import ariel.actiongroups.main.common.challenges.Challenge;

public class ChallengeInfoTabViewImpl extends Fragment implements ChallengeInfoTabView {

    private TextView challengeTV;
    private ChallengeInfoPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.frag_challenge_tab, container, false);
        challengeTV = (TextView) fragmentLayout.findViewById(R.id.tvFragFirst);
        presenter = new ChallengeInfoPresenterImpl(this);
        return fragmentLayout;
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroyView();
    }

    @Override
    public void setChallengeDataInViews(Challenge challenge) {
        challengeTV.setText(challenge.getDescription());
    }
}

/*
    private void initNoMessagesTextViewState() {
        Button addChallenge = (Button) fragmentLayout.findViewById(R.id.createChallengeButton);
        ariel.actiongroups.main.common.utils.GoToScreen goToChallengeCreatorScreen = new GoToScreen(getActivity(), ChallengesCreatorActivity.class);
        addChallenge.setOnClickListener(goToChallengeCreatorScreen);
        addChallenge.setVisibility(View.VISIBLE);
    }*/
