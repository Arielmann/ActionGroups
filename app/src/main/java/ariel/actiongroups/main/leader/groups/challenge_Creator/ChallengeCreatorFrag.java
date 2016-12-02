package ariel.actiongroups.main.leader.groups.challenge_creator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.challenge_navigator.SingleChallengeNavigationScreen;
import ariel.actiongroups.main.common.utils.GoToScreen;

/**
 * Created by home on 11/11/2016.
 */
public class ChallengeCreatorFrag extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View creatorLayout = inflater.inflate(R.layout.frag_challenge_creator, container, false);
        Button goToSingleChallengeScreen = (Button) creatorLayout.findViewById(R.id.goToPreview); //TODO: create preview screen
        GoToScreen.setGoToScreenOnClickListener(goToSingleChallengeScreen, getActivity(), SingleChallengeNavigationScreen.class);
        return creatorLayout;
    }
}
