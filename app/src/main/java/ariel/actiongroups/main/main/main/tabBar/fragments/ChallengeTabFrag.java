package ariel.actiongroups.main.main.main.tabBar.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ariel.actiongroups.R;

/**
 * Created by home on 11/7/2016.
 */
public class ChallengeTabFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_challenge_tab, container, false);
        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText("Make 100 push ups before you eat dinner");
        return v;
    }
}

