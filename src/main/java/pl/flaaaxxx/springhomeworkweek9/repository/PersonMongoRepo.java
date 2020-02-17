package pl.flaaaxxx.springhomeworkweek9.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.flaaaxxx.springhomeworkweek9.model.PersonMongo;

@Repository
public interface PersonMongoRepo extends MongoRepository<PersonMongo, String> {
}
