package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.Repositery.ReclamationRepository;
import com.bezkoder.springjwt.models.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService implements IReclamation {
    @Autowired
    ReclamationRepository icourse;

    @Override
    public List<Reclamation> retrieveAllCour() {

        return (List<Reclamation>) icourse.findAll();
    }

    @Override
    public Reclamation addCour(Reclamation s) {
        //    s.setDate_start(LocalDateTime.now());

        return icourse.save(s);
    }
    @Override
    public Reclamation retrieveCourseById(Long id) {

        return icourse.findById(id).get();
    }


}
