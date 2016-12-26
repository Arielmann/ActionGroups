package ariel.actiongroups.main.common.challenges.challenge_navigator.challengview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ariel.actiongroups.R;
import ariel.actiongroups.main.leader.challenges.challengecreator.views.ChallengesCreatorActivity;
import ariel.actiongroups.main.common.utils.GoToScreen;

/**
 * Created by home on 11/7/2016.
 */
public class ChallengeViewTabFrag extends Fragment {

    View fragmentLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.frag_challenge_tab, container, false);
        TextView tv = (TextView) fragmentLayout.findViewById(R.id.tvFragFirst);
        tv.setText("Make 100 push ups before you eat dinner");
        return fragmentLayout;
    }

    private void initNoMessagesTextViewState() {
        Button addChallenge = (Button) fragmentLayout.findViewById(R.id.createChallengeButton);
        ariel.actiongroups.main.common.utils.GoToScreen goToChallengeCreatorScreen = new GoToScreen(getActivity(), ChallengesCreatorActivity.class);
        addChallenge.setOnClickListener(goToChallengeCreatorScreen);
        addChallenge.setVisibility(View.VISIBLE);
    }
}

