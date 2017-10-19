package ariel.actiongroups.main.leader.courses.creator.singlecourse.events;

import ariel.actiongroups.main.common.resources.AppStrings;

public class OnCourseUploadFailure {

   private String errorMessage = AppStrings.EM_UPLOAD_FAILED;

    public OnCourseUploadFailure(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
