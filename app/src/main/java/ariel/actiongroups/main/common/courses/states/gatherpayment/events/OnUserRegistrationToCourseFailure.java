package ariel.actiongroups.main.common.courses.states.gatherpayment.events;

import ariel.actiongroups.main.common.resources.AppStrings;

public class OnUserRegistrationToCourseFailure {

   private String errorMessage = AppStrings.EM_UPLOAD_FAILED;

    public OnUserRegistrationToCourseFailure(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
