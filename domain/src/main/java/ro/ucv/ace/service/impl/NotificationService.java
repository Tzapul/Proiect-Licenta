package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ucv.ace.dto.notification.NotificationDto;
import ro.ucv.ace.model.Notification;
import ro.ucv.ace.repository.INotificationRepository;
import ro.ucv.ace.service.INotificationService;
import ro.ucv.ace.visitor.NotificationVisitor;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 07.12.2016.
 */
@Service("notificationService")
@Transactional
public class NotificationService implements INotificationService {

    @Autowired
    private INotificationRepository notificationRepository;

    @Autowired
    private NotificationVisitor visitor;

    @Override
    public List<NotificationDto> getUserNotifications(int userId) {
        List<Notification> notifications = notificationRepository.findByUser(userId);
        List<NotificationDto> notificationDtos = new ArrayList<>();

        notifications.forEach(notification -> {
            notification.accept(visitor);
            notificationDtos.add(visitor.getNotificationDto());
        });

        return notificationDtos;
    }

    @Override
    public List<NotificationDto> getUserUnseenNotifications(int userId) {
        List<Notification> notifications = notificationRepository.findUnseenByUser(userId);
        List<NotificationDto> notificationDtos = new ArrayList<>();

        notifications.forEach(notification -> {
            notification.accept(visitor);
            notificationDtos.add(visitor.getNotificationDto());
        });

        return notificationDtos;
    }

    @Override
    public NotificationDto makeNotificationSeen(int id) {
        Notification notification = notificationRepository.findOne(id);
        notification.setSeen(true);
        notification = notificationRepository.save(notification);
        notification.accept(visitor);

        return visitor.getNotificationDto();
    }
}
