package ro.ucv.ace.socket.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.socket.client.IO;
import io.socket.client.Socket;
import org.springframework.beans.factory.DisposableBean;
import ro.ucv.ace.exception.SocketConnectionException;
import ro.ucv.ace.socket.IJob;
import ro.ucv.ace.socket.IJobResult;
import ro.ucv.ace.socket.ISocketManager;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ctotolin on 19-Nov-16.
 */
public class SocketManager implements ISocketManager, DisposableBean {

    private String protocol;

    private String host;

    private String port;

    private Socket socket = null;

    private boolean connected = false;

    private ExecutorService pool;

    private ObjectMapper mapper;

    public SocketManager(String protocol, String port, String host) {
        this.protocol = protocol;
        this.port = port;
        this.host = host;
        this.pool = Executors.newFixedThreadPool(10);
        this.mapper = new ObjectMapper();
        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

        startListening();
    }

    private void startListening() {
        try {
            this.socket = IO.socket(protocol + "://" + host + ":" + port);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.socket.connect();
    }

    /**
     * Sends a job to the Code Verifier server
     * Converts IJob to JSON using class mapper
     *
     * @param job Any type of supported job
     * @return Future of the job's result
     */
    @Override
    public Future<IJobResult> sendJob(IJob job) {
        // Check if we are still connected to the Code Verifier
        if (!socket.connected()) {
            throw new SocketConnectionException("Not connected to Code Verifier Server");
        }

        // Convert job to a JSON format
        String jobString = "";
        try {
            jobString = this.mapper.writeValueAsString(job);
            System.out.println(jobString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Submit async task to exec pool, and return a future variant of the job result
        return pool.submit(new SocketSender(this.socket, this.mapper, job.getType().getName(), jobString));
    }

    @Override
    public void destroy() throws Exception {
        this.socket.disconnect();
        this.pool.shutdown();
    }
}
