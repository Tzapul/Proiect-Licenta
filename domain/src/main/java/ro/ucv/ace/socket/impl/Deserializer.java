package ro.ucv.ace.socket.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import ro.ucv.ace.model.enums.JobType;
import ro.ucv.ace.socket.IDeserializer;
import ro.ucv.ace.socket.IJobResult;

import java.io.IOException;

/**
 * Created by Geo on 02.12.2016.
 */
public class Deserializer implements IDeserializer {

    private ObjectMapper mapper = new ObjectMapper();

    public Deserializer() {
        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    @Override
    public IJobResult deserializeJobResult(JSONObject json, String type) {
        IJobResult result = null;
        try {
            JobType jobType = JobType.fromName(type);
            switch (jobType) {
                case COMPILE:
                    result = mapper.readValue(json.toString(), CompilationJobResult.class);
                    break;
                case TEST:
                    result = mapper.readValue(json.toString(), TestJobResult.class);
                    break;
                case PLAGIARISM:
                    result = mapper.readValue(json.toString(), PlagiarismJobResult.class);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
