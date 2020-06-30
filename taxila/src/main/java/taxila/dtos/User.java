package taxila.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String name;
    private String email;
    private String pwd;
    private String redirect_url;
}
