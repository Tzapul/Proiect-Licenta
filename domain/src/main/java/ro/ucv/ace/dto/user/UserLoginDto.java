package ro.ucv.ace.dto.user;

import javax.validation.constraints.Size;

/**
 * Created by tzapt on 11/16/2016.
 */
public class UserLoginDto {

    @Size(min = 4, max = 20)
    private String username;

    @Size(min = 4, max = 30)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
