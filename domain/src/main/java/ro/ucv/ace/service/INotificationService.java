package ro.ucv.ace.service;

import ro.ucv.ace.dto.notification.NotificationDto;

import java.util.List;

/**
 * Created by Geo on 07.12.2016.
 */
public interface INotificationService {
    List<NotificationDto> getUserNotifications(int userId);

    List<NotificationDto> getUserUnseenNotifications(int userId);

    NotificationDto makeNotificationSeen(int id);
}
