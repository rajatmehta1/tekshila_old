package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.Subscribe;

@Repository
public interface SubscribeRepository extends MongoRepository<Subscribe, String> {
}
