package com.bezkoder.springjwt.Services;


import com.bezkoder.springjwt.Repositery.DossierRepository;
import com.bezkoder.springjwt.Repositery.PostsRepository;
import com.bezkoder.springjwt.models.Posts;
import com.bezkoder.springjwt.models.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierService implements IDossier {
    @Autowired
    DossierRepository dossierRepository;
@Autowired
PostsRepository certif_testRepository;
    @Override
    public List<Dossier> retrieveProblems() {
        return (List<Dossier>) dossierRepository.findAll();
    }

    @Override
    public Dossier addProblem(Dossier s) {
    //    s.setDate_start(LocalDateTime.now());
        return dossierRepository.save(s);
    }

    @Override
    public void deleteProblemById(Long id) {
        dossierRepository.deleteById(id);

    }

    @Override
    public void deleteProblem(Dossier s) {
        dossierRepository.delete(s);
    }

    @Override
    public Dossier updateProblem(Dossier s) {
        return dossierRepository.save(s);
    }

    @Override
    public Dossier retrieveProblemById(Long id) {
        return dossierRepository.findById(id).get();
    }

    @Override
    public Dossier AddTestProb(Dossier test, Long testid) {

        Posts dep = certif_testRepository.findById(testid).orElse(null);


     //   test.setCertif(dep);
        return  dossierRepository.save(test);

    }
}
