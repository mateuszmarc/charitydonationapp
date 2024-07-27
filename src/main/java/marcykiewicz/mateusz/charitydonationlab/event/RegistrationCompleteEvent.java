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

    public RegistrationCompleteEvent(Object source, User user, String applicationUrl) {
        super(source);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
