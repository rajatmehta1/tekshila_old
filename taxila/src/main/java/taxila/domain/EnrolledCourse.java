package taxila.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter @Setter
@Document(collection = "enrolled_courses")
public class EnrolledCourse implements Serializable {

    public String userId;
    public String courseId;
    public String status;

}
