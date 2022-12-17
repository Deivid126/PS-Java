package repositories;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.TransModels;

@Repository
public interface TransRepository extends JpaRepository<TransModels,Id> {
}
