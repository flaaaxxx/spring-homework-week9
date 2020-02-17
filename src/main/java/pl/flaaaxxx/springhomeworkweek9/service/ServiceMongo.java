package pl.flaaaxxx.springhomeworkweek9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springhomeworkweek9.model.PersonMongo;
import pl.flaaaxxx.springhomeworkweek9.model.PersonSql;
import pl.flaaaxxx.springhomeworkweek9.repository.PersonMongoRepo;
import pl.flaaaxxx.springhomeworkweek9.repository.PersonSqlRepo;

import java.util.List;

@Service
public class ServiceMongo {

    private PersonMongoRepo personMongoRepo;

    @Autowired
    public ServiceMongo(PersonMongoRepo personMongoRepo) {
        this.personMongoRepo = personMongoRepo;
    }

    public void saveMongo(List<PersonMongo> personMongoList){
        personMongoRepo.saveAll(personMongoList);
    }

    public List<PersonMongo> readMongo(){
        return personMongoRepo.findAll();
    }
}
