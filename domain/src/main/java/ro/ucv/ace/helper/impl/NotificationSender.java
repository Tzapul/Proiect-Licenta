package ro.ucv.ace.helper.impl;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ucv.ace.converter.StringConverter;
import ro.ucv.ace.helper.INotificationSender;
import ro.ucv.ace.model.Reservation;
import ro.ucv.ace.repository.IReservationRepository;
import sun.net.www.http.HttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by tzapt on 7/3/2017.
 */
@Component
public class NotificationSender implements INotificationSender {

    @Override
    public void sendNotification(Date date) {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");

        post.setHeader("Content-type", "application/json");
        post.setHeader("Authorization", "key=" + "AIzaSyCZIukxhYWEpjwoqE6NJOYEG0oPDZW1kFY");

        JSONObject message = new JSONObject();
        JSONObject notification = new JSONObject();

        try {
            message.put("to", "/topics/" + date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
            message.put("priority", "high");

            notification.put("message", "Your booking was cancelled because the restaurant is taking a day off on that day.");
            notification.put("title", "Cancelled booking " + date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());

            message.put("data", notification);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        post.setEntity(new StringEntity(message.toString(), "UTF-8"));

        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response);
        System.out.println(message);

    }
}
