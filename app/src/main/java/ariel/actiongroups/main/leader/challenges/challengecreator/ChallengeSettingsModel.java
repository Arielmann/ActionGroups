package ariel.actiongroups.main.leader.challenges.challengecreator;

import android.graphics.Bitmap;

import org.joda.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

public class ChallengeSettingsModel {

    private String id;
    private String groupName;
    private String challengeName;
    private Bitmap challengeImage;
    private List<String> objectives;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    public ChallengeSettingsModel(String groupName) {
        id = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.startDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.endDate = String.valueOf(LocalDateTime.now().toLocalDate());
        this.startTime = String.valueOf(LocalDateTime.now().toLocalTime());
        this.endTime = String.valueOf(LocalDateTime.now().toLocalTime());
    }
}
