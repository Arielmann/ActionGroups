package ariel.actiongroups.main.main.main.groups.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import ariel.actiongroups.main.main.main.challenge.ChallengeScreen;
import ariel.actiongroups.main.main.main.groups.model.ActionGroup;
import ariel.actiongroups.main.main.main.utils.GoToScreen;

/**
 * Created by home on 7/27/2016.
 */
public class OnGroupClicked implements View.OnClickListener{

    private Context context;
    private String[] name;

    public OnGroupClicked(Context context, String name[]) {
        this.context = context;
        this.name = name;
    }

    @Override
    public void onClick(View v) {
        Intent chatScreenIntent = new Intent(context, ChallengeScreen.class);
        chatScreenIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ActionGroup group = new ActionGroup();
        EventBus.getDefault().postSticky(group); //send data on this group
        context.startActivity(chatScreenIntent); //TODO: disable click after first time, else it search database twice (רחמנא ליצלן)
    }
}
