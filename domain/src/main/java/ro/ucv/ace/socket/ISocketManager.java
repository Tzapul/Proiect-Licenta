package ro.ucv.ace.socket;

import java.util.concurrent.Future;

/**
 * Created by Geo on 19.11.2016.
 */
public interface ISocketManager {

    Future<IJobResult> sendJob(IJob job);
}
