package marcykiewicz.mateusz.charitydonationlab.event;

import lombok.Getter;
import lombok.Setter;
import marcykiewicz.mateusz.charitydonationlab.user.User;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
