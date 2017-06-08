package ro.ucv.ace.socket;

import org.json.JSONObject;

/**
 * Created by Geo on 02.12.2016.
 */
public interface IDeserializer {
    IJobResult deserializeJobResult(JSONObject json, String type);


}
