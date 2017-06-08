package ro.ucv.ace.repository;

import ro.ucv.ace.model.Notification;

import java.util.List;

/**
 * Created by Geo on 06.12.2016.
 */
public interface INotificationRepository {

    List<Notification> findByUser(int userId);

    List<Notification> findUnseenByUser(int userId);

    Notification findOne(int id);

    Notification save(Notification notification);
}
