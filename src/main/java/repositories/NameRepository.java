package repositories;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.NameRespModels;

@Repository
public interface NameRepository extends JpaRepository<NameRespModels,Id> {

}
