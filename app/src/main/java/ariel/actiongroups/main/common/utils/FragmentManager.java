package ariel.actiongroups.main.common.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class FragmentManager {

    public static Fragment buildFrag(Context context, Fragment frag, String fragTag) {
        ((FragmentActivity) context).getSupportFragmentManager().
                beginTransaction().
                add(frag, fragTag)
                .commit();
        return frag;
    }

    public static Fragment buildFrag(Context context, int containerId, Fragment frag, String fragTag) {
        ((FragmentActivity) context).getSupportFragmentManager().
                beginTransaction().
                add(containerId, frag, fragTag)
                .commit();
        return frag;
    }

    public static void removeFramgnet(Context context, Fragment fragment){
        ((FragmentActivity) context)
                .getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }
}
