package ariel.actiongroups.main.common.challenges.challengenavigator.tabs.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ariel.actiongroups.R;

public class ChatTabFrag extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View chatLayout = inflater.inflate(R.layout.frag_chat_tab, container, false);
            TextView tv = (TextView) chatLayout.findViewById(R.id.tvFragSecond);
            tv.setText("what's up world");
            return chatLayout;
        }
    }

