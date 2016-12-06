package ariel.actiongroups.main.leader.groups.groups_creator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.groups.group_info.GroupInfoScreen;
import ariel.actiongroups.main.common.utils.GoToScreen;

/**
 * Created by home on 11/22/2016.
 */
public class GroupCreatorFrag extends Fragment{

    private static final String GROUP_CREATOR_FRAG = "Group crator frag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.frag_group_creator, container, false);
        Button createGroup = (Button) layout.findViewById(R.id.createGroupButton);
        GoToScreen.setGoToScreenOnClickListener(createGroup, getActivity(), GroupInfoScreen.class);
        TextView codeTV= (TextView) layout.findViewById(R.id.groupCodeTV);
        String groupCode = "Leader Name /" + UUID.randomUUID().toString(); //TODO: compare code with all other codes of specific leader to prevent cloning
        codeTV.setText(groupCode);
        Log.d(GROUP_CREATOR_FRAG, "View created");
        return layout;
    }
}
