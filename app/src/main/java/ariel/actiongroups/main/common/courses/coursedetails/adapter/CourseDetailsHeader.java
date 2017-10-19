package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.util.Log;
import android.view.View;
import android.widget.Switch;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.listutils.ListPresentable;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.common.utils.listutils.vh.OnAddEntityVHClicked;
import ariel.actiongroups.main.common.utils.listutils.vh.vhcontrollers.SilenceEntityWithSwitchVHController;

class CourseDetailsHeader extends GenericViewHolder {

    private static final String TAG = CourseDetailsHeader.class.getSimpleName();
    private OnAddEntityVHClicked onAddGroupVHClicked;

    CourseDetailsHeader(View headerLayout, ListPresentable data, OnAddEntityVHClicked onAddGroupVHClicked) {
        super(headerLayout);
        this.onAddGroupVHClicked = onAddGroupVHClicked;
        initSilenceSwitchController(headerLayout, data);
        initAddGroupVC(headerLayout);
    }

    private void initSilenceSwitchController(View layout, ListPresentable data) {
        Switch silenceSwitch = (Switch) layout.findViewById(R.id.silenceEntitySwitch);
        silenceSwitch.setChecked(data.isSilenced());
        SilenceEntityWithSwitchVHController silenceEntityWithSwitchController = new SilenceEntityWithSwitchVHController(data, silenceSwitch);
        silenceSwitch.setOnCheckedChangeListener(silenceEntityWithSwitchController);
    }

    private void initAddGroupVC(View layout) {
        AddGroupToCourseVHController controller = new AddGroupToCourseVHController(onAddGroupVHClicked);
        View addMemberVHLayout = layout.findViewById(R.id.addMemberVHLayout);
        addMemberVHLayout.setOnClickListener(controller);
    }

    @Override
    public void setUIDataOnView(int position) {
        Log.d(TAG, "Course header bound");
    }
}
