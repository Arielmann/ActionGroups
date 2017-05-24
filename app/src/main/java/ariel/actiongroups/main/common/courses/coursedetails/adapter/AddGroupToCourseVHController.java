package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.view.View;

import ariel.actiongroups.main.common.utils.listutils.vh.OnAddEntityVHClicked;

public class AddGroupToCourseVHController implements View.OnClickListener {

    private OnAddEntityVHClicked onAddGroupVHClicked;

    public AddGroupToCourseVHController(OnAddEntityVHClicked onAddGroupVHClicked) {
        this.onAddGroupVHClicked = onAddGroupVHClicked;
    }

    @Override
    public void onClick(View view) {
        onAddGroupVHClicked.onAddEntityVHClicked();
    }
}
