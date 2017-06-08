package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.INotificationBuilder;
import ro.ucv.ace.model.Notification;

/**
 * Created by Geo on 06.12.2016.
 */
@Component
public class NotificationBuilder implements INotificationBuilder {

    @Override
    public Notification buildCompilerErrorNotification(String taskName, String errorMessage) {
        return new Notification("Error while trying to compile the task with name " + taskName + ". Message is: " + errorMessage + ".");

    }

    @Override
    public Notification buildCompileSuccessNotification(String taskName) {
        return new Notification("Successfully finished compilation for task with name " + taskName + ".");
    }

    @Override
    public Notification buildTestErrorNotification(String taskName, String errorMessage) {
        return new Notification("Error while trying to test the task with name " + taskName + ". Message is: " + errorMessage + ".");
    }

    @Override
    public Notification buildTestSuccessNotification(String taskName, double score) {
        return new Notification("Successfully finished testing task with name " + taskName + ". Your score is " + score + ".");
    }

    @Override
    public Notification buildNewTaskNotification(String topicName, String taskName) {
        return new Notification("On " + topicName + " topic has been added a new task with name " + taskName + ".");
    }
}
