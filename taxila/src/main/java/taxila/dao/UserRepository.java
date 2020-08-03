package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.TekUser;

@Repository
public interface UserRepository extends MongoRepository<TekUser, String> {
       public boolean existsTekUserByUserNameAndPwd(String userName, String pwd);
       public boolean existsTekUserByEmailAndPwd(String email, String pwd);
       public TekUser findTekUserByEmailAndPwd(String email, String pwd);

       public TekUser findTekUserByUserId(int userId);
}
