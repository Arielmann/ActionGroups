package ariel.actiongroups.main.common.challenges.challenge_navigator.chat;

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
public class ChatTabFrag extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.frag_chat_tab, container, false);
            TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
            tv.setText("what's up world");
            return v;
        }
    }

