package pl.flaaaxxx.springhomeworkweek9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springhomeworkweek9.model.PersonSql;
import pl.flaaaxxx.springhomeworkweek9.repository.PersonSqlRepo;

import java.util.List;

@Service
public class ServiceSQL {
    private PersonSqlRepo personSqlRepo;

    @Autowired
    public ServiceSQL(PersonSqlRepo personSqlRepo) {
        this.personSqlRepo = personSqlRepo;
    }

    public void saveSQL(List<PersonSql> personSqlList){
        personSqlRepo.saveAll(personSqlList);
    }

    public List<PersonSql> readSQL(){
        return personSqlRepo.findAll();
    }

}
