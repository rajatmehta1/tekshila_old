package taxila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscribers")
@Getter @Setter
public class Subscribe {

    @Id
    private ObjectId _id;

    private String email;
}
