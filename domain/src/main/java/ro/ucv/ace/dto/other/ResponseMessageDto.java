package ro.ucv.ace.dto.other;

/**
 * Created by tzapt on 12/4/2016.
 */
public class ResponseMessageDto {

    private boolean error;

    private String message;

    public ResponseMessageDto(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
