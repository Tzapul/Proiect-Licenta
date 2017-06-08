package ro.ucv.ace.builder;

import ro.ucv.ace.model.Notification;

/**
 * Created by Geo on 06.12.2016
 */
public interface INotificationBuilder {

    Notification buildCompilerErrorNotification(String taskName, String errorMessage);

    Notification buildCompileSuccessNotification(String taskName);

    Notification buildTestErrorNotification(String taskName, String errorMessage);

    Notification buildTestSuccessNotification(String taskName, double score);

    Notification buildNewTaskNotification(String topicName, String taskName);
}
