package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.notification.NotificationDto;
import ro.ucv.ace.model.Notification;

/**
 * Created by Geo on 07.12.2016.
 */
@Component
public class NotificationVisitor {

    private NotificationDto notificationDto;

    public void visit(Notification notification) {
        notificationDto = new NotificationDto(notification.getId(), notification.getMessage(), notification.getDate().toString()
                , notification.getSeen());
    }

    public NotificationDto getNotificationDto() {
        return notificationDto;
    }
}
