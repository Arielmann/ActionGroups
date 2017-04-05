package ariel.actiongroups.main.common.courses.states.challengenavigator.tabs.results;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 11/8/2016.
 */
public class CompletionTableModel {

    private static final String TAG = "Chat Data Model";
    private Context context;
    private CompletionTableAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<String> users;

    public CompletionTableModel(Context context) {
        users = new ArrayList<>();
        users.add("Ariel Mann");
        users.add("Ben Carmel");
        users.add("Rotem Grinberg");
        this.context = context;
        this.layoutManager = new GridLayoutManager(context, 2);
        this.adapter = new CompletionTableAdapter(users);
    }

    //********************Getters*********************//
    public Context getContext() {
        return context;
    }

    public CompletionTableAdapter getAdapter() {
        return adapter;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public List<String> getChatItems() {
        return users;
    }
}
