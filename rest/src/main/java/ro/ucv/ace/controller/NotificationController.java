package ro.ucv.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ucv.ace.dto.notification.NotificationDto;
import ro.ucv.ace.service.INotificationService;

import java.util.List;

/**
 * Created by Geo on 07.12.2016.
 */
@RestController
@RequestMapping(value = "/users")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @RequestMapping(value = "/{userId}/notifications", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDto>> getAllNotifications(@PathVariable("userId") int userId) {
        List<NotificationDto> notificationDtos = notificationService.getUserNotifications(userId);

        return new ResponseEntity<List<NotificationDto>>(notificationDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}/notifications/unseen", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDto>> getUnseenNotifications(@PathVariable("userId") int userId) {
        List<NotificationDto> notificationDtos = notificationService.getUserUnseenNotifications(userId);

        return new ResponseEntity<List<NotificationDto>>(notificationDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/notifications/{id}/seen", method = RequestMethod.PUT)
    public ResponseEntity<NotificationDto> makeNotificationSeen(@PathVariable("id") int id) {
        NotificationDto notificationDto = notificationService.makeNotificationSeen(id);

        return new ResponseEntity<NotificationDto>(notificationDto, HttpStatus.OK);
    }

}
