package pl.flaaaxxx.springhomeworkweek9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.flaaaxxx.springhomeworkweek9.aop.TimeAspect;
import pl.flaaaxxx.springhomeworkweek9.aop.TimeCounter;
import pl.flaaaxxx.springhomeworkweek9.model.PersonMongo;
import pl.flaaaxxx.springhomeworkweek9.model.PersonSql;
import pl.flaaaxxx.springhomeworkweek9.repository.PersonSqlRepo;
import pl.flaaaxxx.springhomeworkweek9.repository.PersonMongoRepo;
import pl.flaaaxxx.springhomeworkweek9.service.ServiceMongo;
import pl.flaaaxxx.springhomeworkweek9.service.ServiceSQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Start {
    private ServiceSQL serviceSQL;
    private ServiceMongo serviceMongo;
    private List<PersonSql> personSqlList;
    private List<PersonMongo> personMongoList;

    public Start(ServiceSQL serviceSQL, ServiceMongo serviceMongo) {
        this.serviceSQL = serviceSQL;
        this.serviceMongo = serviceMongo;
        this.personSqlList = new ArrayList<>();
        this.personMongoList = new ArrayList<>();
    }

    @Autowired



    @EventListener(ApplicationReadyEvent.class)
    @TimeAspect
    public void init(){
        readFromCSV();
        serviceSQL.saveSQL(personSqlList); // 383
//        personSqlList = serviceSQL.readSQL(); // 16
//        serviceMongo.saveMongo(personMongoList); // 826
//        personMongoList = serviceMongo.readMongo(); // 23
    }

    private void readFromCSV() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MOCK_DATA.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i=0; i<records.size(); i++){
            personSqlList.add(new PersonSql(Long.parseLong(records.get(i).get(0)),
                                                                records.get(i).get(1),
                                                                records.get(i).get(2),
                                                                records.get(i).get(3),
                                                                records.get(i).get(4),
                                                                records.get(i).get(5)));

            personMongoList.add(new PersonMongo(records.get(i).get(0),
                                                                records.get(i).get(1),
                                                                records.get(i).get(2),
                                                                records.get(i).get(3),
                                                                records.get(i).get(4),
                                                                records.get(i).get(5)));

        }

    }

}
