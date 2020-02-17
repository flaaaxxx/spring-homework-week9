package pl.flaaaxxx.springhomeworkweek9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.flaaaxxx.springhomeworkweek9.model.PersonSql;

@Repository
public interface PersonSqlRepo extends JpaRepository<PersonSql, Long> {
}
