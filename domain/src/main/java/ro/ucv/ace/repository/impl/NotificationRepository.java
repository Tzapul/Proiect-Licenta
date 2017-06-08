package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Notification;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.INotificationRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Geo on 06.12.2016.
 */
@Repository("notificationRepository")
public class NotificationRepository implements INotificationRepository {

    @Autowired
    private IJpaRepository<Notification, Integer> innerNotificationRepository;


    @Override
    public List<Notification> findByUser(int userId) {
        return innerNotificationRepository
                .findAllWhere(notification -> notification.getAccount().getUser().getId().equals(userId));
    }

    @Override
    public List<Notification> findUnseenByUser(int userId) {
        List<Notification> notifications = innerNotificationRepository.findAllWhere(notification -> notification.getAccount().getUser().getId().equals(userId)
                && !notification.getSeen().equals(true));
        notifications = notifications.stream().sorted((n1, n2) -> n2.getDate().compareTo(n1.getDate())).collect(Collectors.toList());

        return notifications;
    }

    @Override
    public Notification findOne(int id) {
        return innerNotificationRepository.findOne(id);
    }

    @Override
    public Notification save(Notification notification) {
        return innerNotificationRepository.save(notification);
    }
}
