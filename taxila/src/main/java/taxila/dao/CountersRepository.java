package taxila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import taxila.domain.Counters;
import taxila.domain.Course;

import java.util.List;

@Repository
public interface CountersRepository extends MongoRepository<Counters, String> {

    Counters findBySequenceName(String sequenceName);

}
