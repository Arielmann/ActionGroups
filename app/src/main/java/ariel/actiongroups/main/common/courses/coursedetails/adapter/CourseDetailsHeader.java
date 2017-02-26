package ariel.actiongroups.main.common.courses.coursedetails.adapter;

import android.util.Log;
import android.view.View;
import android.widget.Switch;

import ariel.actiongroups.R;
import ariel.actiongroups.main.common.utils.listutils.OnAddEntityVHClicked;
import ariel.actiongroups.main.common.profiles.models.ActionGroupsEntity;
import ariel.actiongroups.main.common.utils.listutils.vh.GenericViewHolder;
import ariel.actiongroups.main.common.utils.vhcontrollers.AddGroupToCourseController;
import ariel.actiongroups.main.common.utils.vhcontrollers.SilenceEntityWithSwitchController;

class CourseDetailsHeader extends GenericViewHolder {

    private static final String TAG = CourseDetailsHeader.class.getSimpleName();
    private OnAddEntityVHClicked onAddGroupVHClicked;

    CourseDetailsHeader(View headerLayout, ActionGroupsEntity entity, OnAddEntityVHClicked onAddGroupVHClicked) {
        super(headerLayout);
        this.onAddGroupVHClicked = onAddGroupVHClicked;
        initSilenceSwitchController(headerLayout, entity);
        initAddGroupVC(headerLayout);
    }

    private void initSilenceSwitchController(View layout, ActionGroupsEntity entity) {
        Switch silenceSwitch = (Switch) layout.findViewById(R.id.silenceEntitySwitch);
        silenceSwitch.setChecked(entity.isSilenced());
        SilenceEntityWithSwitchController silenceEntityWithSwitchController = new SilenceEntityWithSwitchController(entity, silenceSwitch);
        silenceSwitch.setOnCheckedChangeListener(silenceEntityWithSwitchController);
    }

    private void initAddGroupVC(View layout) {
        AddGroupToCourseController controller = new AddGroupToCourseController(onAddGroupVHClicked);
        View addMemberVHLayout = layout.findViewById(R.id.addMemberVHLayout);
        addMemberVHLayout.setOnClickListener(controller);
    }

    @Override
    public void setUIDataOnView(int position) {
        Log.d(TAG, "Course header bound");
    }
}
