package taxila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "users")
public class TekUser {

    @Id
    private ObjectId _id;

    private int userId;
    private String name;
    private String email;
    private String userName;
    private String pwd;
//    private String isTeacher;

}