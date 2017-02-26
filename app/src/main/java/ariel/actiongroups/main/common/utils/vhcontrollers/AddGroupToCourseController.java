package ariel.actiongroups.main.common.utils.vhcontrollers;

import android.view.View;

import ariel.actiongroups.main.common.utils.listutils.OnAddEntityVHClicked;

public class AddGroupToCourseController implements View.OnClickListener {

    private OnAddEntityVHClicked onAddGroupVHClicked;

    public AddGroupToCourseController(OnAddEntityVHClicked onAddGroupVHClicked) {
        this.onAddGroupVHClicked = onAddGroupVHClicked;
    }

    @Override
    public void onClick(View view) {
        onAddGroupVHClicked.onAddEntityVHClicked();
    }
}
