package ariel.actiongroups.main.common.courses.states.gatherpayment.events;

import ariel.actiongroups.main.common.resources.AppStrings;

public class OnGroupRegistrationToCourseFailure {

   private String errorMessage = AppStrings.EM_UPLOAD_FAILED;

    public OnGroupRegistrationToCourseFailure(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
