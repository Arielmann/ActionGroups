package ariel.actiongroups.main.common.groups.groupdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.ActivityStarter;
import ariel.actiongroups.main.leader.challenges.manager.view.ChallengeEditorActivity;

/**
 * Created by home on 11/29/2016.
 */
public class GroupInfoFrag extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View groupMainLayout = inflater.inflate(R.layout.frag_group_info, null);
        Button createChallenge = (Button) groupMainLayout.findViewById(R.id.createChallengeButton);
        ActivityStarter.setStartActivityOnClickListener(createChallenge, getActivity(), ChallengeEditorActivity.class);
        return groupMainLayout;
    }
}
