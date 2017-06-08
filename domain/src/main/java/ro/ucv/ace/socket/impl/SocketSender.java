package ro.ucv.ace.socket.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.socket.client.Ack;
import io.socket.client.Socket;
import org.json.JSONObject;
import ro.ucv.ace.socket.IDeserializer;
import ro.ucv.ace.socket.IJobResult;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ctotolin on 19-Nov-16.
 */
public class SocketSender implements Callable<IJobResult> {

    private String type;

    private Socket socket;

    private String message;

    private ObjectMapper mapper;

    private AtomicBoolean done = new AtomicBoolean(false);

    private IDeserializer deserializer = new Deserializer();

    public SocketSender(Socket socket, ObjectMapper mapper, String type, String message) {
        this.socket = socket;
        this.message = message;
        this.type = type;
        this.mapper = mapper;
    }

    /**
     * Sends a job message to the code verifier server through existent socket
     *
     * @return JobResult result of that IJob message
     * @throws Exception
     */
    @Override
    public IJobResult call() throws Exception {
        final BlockingQueue<JSONObject> response = new LinkedBlockingQueue<>();

        this.socket.emit(this.type, this.message, (Ack) args -> {
            // Get JSONObject response
            JSONObject jsonResponse = (JSONObject) args[0];

            // Offer it to the queue
            response.offer(jsonResponse);

            done.set(true);
            System.out.println("Received response from server");
        });

        // Read value from queue, convert to JobR result and return it
        // TODO: make sure response is a valid IJobResult , otherwise throw JsonParseException
        while (!done.get()) {
        }

        return deserializer.deserializeJobResult(response.take(), type);
    }
}
