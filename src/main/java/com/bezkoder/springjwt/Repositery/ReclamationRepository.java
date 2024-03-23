package com.bezkoder.springjwt.Repositery;

import com.bezkoder.springjwt.models.Reclamation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
}
